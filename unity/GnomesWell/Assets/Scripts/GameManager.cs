using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : Singleton<GameManager>
{
    // ノームが現れる位置
    public GameObject startingPoint;

    // ノームを下ろしたり上げたりするロープオブジェクト
    public Rope rope;

    // ノームを追従するためのスクリプト
    public CameraFollow cameraFollow;

    // 「現在の」ノーム（死亡したのとは別のノーム）
    Gnome currentGnome;

    // 新しいノームが必要になったときにインスタンス化するためのプレハブ
    public GameObject gnomePrefab;

    // restartとresumeボタンを含むUIコンポーネント
    public RectTransform mainMenu;

    // up, down, menuボタンを含むUIコンポーネント
    public RectTransform gameplayMenu;

    // 「You win！」のスクリーンを含むUIコンポーネント
    public RectTransform gameOverMenu;

    // Unity Events
    // もし真なら、すべてのダメージを無視する（しかし、ダメージエフェクトは
    // 表示し続ける）。「get; set;」と記述することでこの変数はプロパティーとして扱え、
    // [Inspector]内のUnity Eventsのメソッドのリストに表示されるようになる
    public bool gnomeInvincible { get; set; }

    // 死亡後、新しいノームを作成する前にどの程度待つか
    public float delayAfterDeath = 1.0f;

    // ノームが死んだときに再生するサウンド
    public AudioClip gnomeDiedSound;

    // プレイヤーがゲームに勝利したときに再生するサウンド
    public AudioClip gameOverSound;

    /// <summary>
    /// 5.3.1 ゲームのセットアップとリセット 
    /// </summary>
    void Start()
    {
        // ゲームを開始したときに、Resetを呼び出してノームをセットアップする
        Reset();
    }

    // ゲームをリセットする
    public void Reset()
    {
        // メニューを非表示にして、ゲームプレイ用のUIを表示する
        if (gameOverMenu)
            gameOverMenu.gameObject.SetActive(false);

        if (mainMenu)
            mainMenu.gameObject.SetActive(false);

        if (gameplayMenu)
            gameplayMenu.gameObject.SetActive(false);

        // すべてのResettableコンポーネントを探して
        // リセットするように伝える
        var resetObjects = FindObjectsOfType<Resettable>();
        foreach(Resettable r in resetObjects)
        {
            r.Reset();
        }

        // 新しいノームを作成
        CreateNewGnome();

        // ゲームを再開する
        Time.timeScale = 1.0f;
    }

    /// <summary>
    /// 5.3.2 新しいノームの作成 
    /// </summary>
    void CreateNewGnome()
    {
        // もしノームがいるのなら、現在のノームを破棄する
        RemoveGnome();

        // 新しいGnomeオブジェクトを作成して、currentGnomeとして使用する
        GameObject newGnome = (GameObject)Instantiate(gnomePrefab,
            startingPoint.transform.position, Quaternion.identity);
        currentGnome = newGnome.GetComponent<Gnome>();

        // ロープを可視状態にする
        rope.gameObject.SetActive(true);

        // ロープの末尾をどこでも良いので、ノームのリジッドボディ（例えば脚）に接続する
        rope.connectedObject = currentGnome.ropeBody;

        // ロープの長さをデフォルトにリセットする
        rope.ResetLength();

        // cameraFollowに新しいノームオブジェクトを追従するように伝える
        cameraFollow.target = currentGnome.cameraFollowTarget;
    }

    /// <summary>
    /// 5.3.3 古いノームの破棄 
    /// </summary>
    void RemoveGnome()
    {
        // ノームが無敵状態なら何もしない
        if (gnomeInvincible)
            return;

        // ロープを不可視状態にする
        rope.gameObject.SetActive(false);

        // ノームの追従をやめる
        cameraFollow.target = null;

        // もし現在ノームがいるなら、これ以上プレイヤーとして存在しないようにする
        if(currentGnome != null)
        {
            // もうこのノームは宝をつかむことはない
            currentGnome.holdingTreasure = false;
            
            // プレイヤーでないとマーキングする
            // （コライダーにオブジェクトが当たっても、
            // コライダーが反応しないようになる）
            currentGnome.gameObject.tag = "Untagged";

            // 現在"Player"としてタグ付けされている
            // すべてのオブジェクトからそのタグを取り除く
            foreach(Transform child in
                currentGnome.transform)
            {
                child.gameObject.tag = "Untagged";
            }
        }

        // 現在のノームを保持していない状態にする
        currentGnome = null;
    }

    /// <summary>
    /// 5.3.3.1 ノームを死亡させる
    /// </summary>
    /// <param name="damageType"></param>

    void killGnome(Gnome.DamageType damageType)
    {
        // もしオーディオソースを持っているなら
        // ノームが死んだときのサウンドを再生する
        var audio = GetComponent<AudioSource>();
        if (audio)
        {
            audio.PlayOneShot(this.gnomeDiedSound);
        }

        // ダメージエフェクトを表示する
        currentGnome.ShowDamageEffect(damageType);

        // もし無敵状態でないなら、ゲームをリセットして、
        // ノームを現在のプレイヤーでなくする
        if(gnomeInvincible == false)
        {
            // ノームに死亡したことを伝える
            currentGnome.DestroyGnome(damageType);

            // ノームを取り除く
            RemoveGnome();

            // ゲームをリセットする
            StartCoroutine(ResetAfterDelay());
        }
    }

    /// <summary>
    /// 5.3.4 ゲームのリセット 
    /// ノームが死亡したときに呼ばれる
    /// </summary>
    /// <returns></returns>
    IEnumerator ResetAfterDelay()
    {
        // delayAfterDeath秒待ってからResetを呼ぶ
        yield return new WaitForSeconds(delayAfterDeath);
        Reset();
    }

    /// <summary>
    /// 5.3.5 接触を処理する 
    /// プレイヤーがトラップに接触したときに呼ばれる
    /// </summary>
    public void TrapTouched()
    {
        killGnome(Gnome.DamageType.Slicing);
    }

    // プレイヤーが火のトラップに接触したときに呼ばれる
    public void FireTrapTouched()
    {
        killGnome(Gnome.DamageType.Burning);
    }

    // ノームが宝を持ち上げたときに呼ばれる
    public void TreasureCollected()
    {
        // 現在のノームに宝を持つように伝える
        currentGnome.holdingTreasure = true;
    }

    /// <summary>
    /// 5.3.6 出口に到達する
    /// プレイヤーが出口に接触したときに呼ばれる
    /// </summary>
    public void ExitReached()
    {
        // もしプレイヤーがいて、そのプレイヤーが宝を持っているなら
        // ゲームオーバー！
        if(currentGnome != null &&
            currentGnome.holdingTreasure == true)
        {
            // もしオーディオソースを持っているなら、
            // ゲームオーバー時のサウンドを再生する
            var audio = GetComponent<AudioSource>();
            if (audio)
            {
                audio.PlayOneShot(this.gameOverSound);
            }
            // ゲームを一時停止する
            Time.timeScale = 0.0f;

            // GameOverメニューを非表示にして、
            // ゲームオーバー画面を表示する
            if (gameOverMenu)
            {
                gameOverMenu.gameObject.SetActive(true);
            }
            if (gameplayMenu)
            {
                gameplayMenu.gameObject.SetActive(false);
            }
        }
    }

    // MenuボタンとResume Gameボタンが押されたときに呼ばれる
    public void SetPaused(bool paused)
    {
        // 一時停止状態なら、時間を止めてメニューを表示する
        // （そしてプレイ用UIを非表示にする）
        if (paused)
        {
            Time.timeScale = 0.0f;
            mainMenu.gameObject.SetActive(true);
            gameplayMenu.gameObject.SetActive(false);
        } else
        {
            // 一時停止状態でないなら、再開してメニューを非表示にする
            // （そしてプレイ用UIを表示する）
            Time.timeScale = 1.0f;
            mainMenu.gameObject.SetActive(false);
            gameplayMenu.gameObject.SetActive(true);
        }
    }

    public void RestartGame()
    {
        // すぐにノームを（死亡させる代わりに）破棄する
        Destroy(currentGnome.gameObject);
        currentGnome = null;

        // ゲームをリセットし、新しいノームを作成する
        Reset();
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
