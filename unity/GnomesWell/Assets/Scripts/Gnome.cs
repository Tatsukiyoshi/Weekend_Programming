using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// 5.2 ノームのコードのセットアップ
public class Gnome : MonoBehaviour
{
    // カメラが追従するオブジェクト
    public Transform cameraFollowTarget;

    public Rigidbody2D ropeBody;

    public Sprite armHoldingEmpty;

    public Sprite armHoldingTreasure;

    public SpriteRenderer holdingArm;

    public GameObject deathPrefab;
    public GameObject flameDeathPrefab;
    public GameObject ghostPrefab;

    public float delayBeforeRemoving = 3.0f;
    public float delayBeforeReleasingGhost = 0.25f;

    public GameObject bloodFountainPrefab;

    bool dead = false;

    bool _holdingTreasure = false;

    public bool holdingTreasure
    {
        get
        {
            return _holdingTreasure;
        }

        set
        {
            if(dead == true)
            {
                return;
            }

            _holdingTreasure = value;

            if(holdingArm != null)
            {
                if (_holdingTreasure)
                {
                    holdingArm.sprite = armHoldingTreasure;
                } else
                {
                    holdingArm.sprite = armHoldingEmpty;
                }
            }
        }
    }

    public enum DamageType
    {
        Slicing,
        Burning
    }

    public void ShowDamageEffect(DamageType type)
    {
        switch (type)
        {
            case DamageType.Burning:
                if(flameDeathPrefab != null)
                {
                    Instantiate(flameDeathPrefab,
                        cameraFollowTarget.position,
                        cameraFollowTarget.rotation
                        );
                }
                break;
            case DamageType.Slicing:
                if (flameDeathPrefab != null)
                {
                    Instantiate(deathPrefab,
                        cameraFollowTarget.position,
                        cameraFollowTarget.rotation
                        );
                }
                break;

        }
    }

    public void DestroyGnome(DamageType type)
    {
        holdingTreasure = false;

        dead = true;

        // すべての子オブジェクトを見つけて、
        // それらのジョイントを無作為に切断する
        foreach(BodyPart part in
            GetComponentsInChildren<BodyPart>())
        {
            switch (type)
            {
                case DamageType.Burning:
                    // 1/3の確率で燃える
                    bool shouldBurn = Random.Range(0, 2) == 0;
                    if (shouldBurn)
                    {
                        part.ApplyDamageSprite(type);
                    }
                    break;
                case DamageType.Slicing:
                    // 切るダメージは毎回ダメージスプライトを適用する
                    part.ApplyDamageSprite(type);

                    break;
            }
            // 1/3の確率で身体から外れる
            bool shouldDetach = Random.Range(0, 2) == 0;
            if (shouldDetach)
            {
                // このオブジェクトが停止したあとに、自身のリジッドボディと
                // コライダーを取り除く
                part.Detach();

                // もし、身体から外れて、ダメージタイプがSlicingなら、
                // 血しぶきを追加
                if(type == DamageType.Slicing)
                {
                    if(part.bloodFountainOrigin != null &&
                        bloodFountainPrefab != null)
                    {
                        // 外れたパーツのために血しぶきをアタッチする
                        GameObject fountain = Instantiate(
                            bloodFountainPrefab,
                            part.bloodFountainOrigin.position,
                            part.bloodFountainOrigin.rotation
                            ) as GameObject;

                        fountain.transform.SetParent(
                            this.cameraFollowTarget,
                            false
                            );
                    }
                }

                // オブジェクトを切断する
                var allJoints = part.GetComponentsInChildren<Joint2D>();
                foreach(Joint2D joint in allJoints)
                {
                    Destroy(joint);
                }
            }
        }

        // RemoveAfterDelayコンポーネントをこのオブジェクトに追加
        var remove = gameObject.AddComponent<RemoveAfterDelay>();
        remove.delay = delayBeforeRemoving;

        StartCoroutine(ReleaseGhost());
    }

    IEnumerator ReleaseGhost()
    {
        // ゴースト用プレハブがないなら子ルーチンを抜ける
        if(ghostPrefab == null)
        {
            yield break;
        }

        // delayBeforeReleasingGhost秒待つ
        yield return new WaitForSeconds(delayBeforeReleasingGhost);

        // ゴースト追加
        Instantiate(
            ghostPrefab,
            transform.position,
            Quaternion.identity
            );
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
