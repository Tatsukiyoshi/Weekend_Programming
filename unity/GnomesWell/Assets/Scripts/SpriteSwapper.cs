using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// 6.2 出口の作成
// あるスプライトを他のスプライトと入れ替える
// 例えば、宝が「ある状態」から「ない状態」に切り替わる
public class SpriteSwapper : MonoBehaviour
{
    // 表示されるべきスプライト
    public Sprite spriteToUse;

    // 新しいスプライトが使うスプライトレンダラー
    public SpriteRenderer spriteRenderer;

    // 元のスプライト。ResetSpliteが呼ばれたときに使用する
    public Sprite originalSprite;

    // スプライトを入れ替える
    public void SwapSprite()
    {
        // 現在のスプライトと異なるものであれば
        if(spriteToUse != spriteRenderer.sprite)
        {
            // originalSpriteに現状のスプライトを格納する
            originalSprite = spriteRenderer.sprite;

            // スプライトレンダラーは新しいスプライトを使う
            spriteRenderer.sprite = spriteToUse;
        }
    }

    // 古いスプライトに戻す
    public void ResetSprite()
    {
        // もし元のスプライトを持っているなら
        if(originalSprite != null)
        {
            // スプライトレンダラーはそれを使う
            spriteRenderer.sprite = originalSprite;
        }
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
