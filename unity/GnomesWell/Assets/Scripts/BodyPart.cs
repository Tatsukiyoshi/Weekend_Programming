using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// 5.2 ノームのコードのセットアップ
public class BodyPart : MonoBehaviour
{
    // ApplyDamageSpriteメソッドが、
    // Slicingダメージで呼ばれたときに使うスプライト
    public Sprite detachedSprite;

    // ApplyDamageSpriteメソッドが、
    // Burningダメージで呼ばれたときに使うスプライト
    public Sprite burnedSprite;

    // メインボディ上に表示する血しぶきの位置と回転を表す
    public Transform bloodFountainOrigin;

    // もし真なら、休止状態のときに、このオブジェクトは
    // コリジョン、ジョイントとリジッドボディを取り除く
    bool detached = false;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // 親オブジェクトから切断して、物理特性を解除するように
    // フラグを立てる
    public void Detach()
    {
        detached = true;
        this.tag = "untagged";
        transform.SetParent(null, true);
    }

    // Update is called once per frame
    // 毎フレーム、もし分離されていてリジッドボディが休止状態なら
    // 物理特性を外す。これにより、この分離されたボディパーツは
    // ノームの行く手を邪魔しなくなる
    void Update()
    {
        // もし分離されていないなら何もしない
        if(detached == false)
        {
            return;
        }

        // リジッドボディが休止状態かどうか
        var rigidbody = GetComponent<Rigidbody2D>();

        if (rigidbody.IsSleeping())
        {
            // もし休止状態ならすべてのジョイントを破棄する
            foreach(Joint2D joint in GetComponentsInChildren<Joint2D>())
            {
                Destroy(joint);
            }
            // すべてのリジッドボディも破棄する
            foreach(Rigidbody2D body in GetComponentsInChildren<Rigidbody2D>())
            {
                Destroy(body);
            }
            // すべてのコリダーも破棄する
            foreach (Collider2D collider in GetComponentsInChildren<Collider2D>())
            {
                Destroy(collider);
            }
            // 最終的にこのスクリプトを取り外す
            Destroy(this);
        }
    }

    // どの種類のダメージを受けたかに応じて
    // このパーツのスクリプトを交換する
    public void ApplyDamageSprite(Gnome.DamageType damageType)
    {
        Sprite spriteToUse = null;

        switch (damageType)
        {
            case Gnome.DamageType.Burning:
                spriteToUse = burnedSprite;
                break;
            case Gnome.DamageType.Slicing:
                spriteToUse = detachedSprite;
                break;
        }

        if(spriteToUse != null)
        {
            GetComponent<SpriteRenderer>().sprite = spriteToUse;
        }
    }
}
