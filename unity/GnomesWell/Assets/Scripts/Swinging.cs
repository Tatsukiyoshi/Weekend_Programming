using UnityEngine;
using System.Collections;

// 5.1.4 InputManagerシングルトンの実装
// InputManagerを使用して、左右方向の力をオブジェクトに適用する
// これでノームを左右に揺らす
public class Swinging : MonoBehaviour
{
    // どのくらい揺らすか？　数値が大きいほど大きく揺れる
    public float swingSensitivity = 100.0f;

    // 物理エンジンの処理をましにするためUpdateの代わりにFixedUpdateを使う
    void FixedUpdate()
    {
        // もし、もうリジッドボディを持っていないなら、このコンポーネントを破棄する
        if(GetComponent<Rigidbody2D>() == null)
        {
            Destroy(this);
            return;
        }

        // 傾きの度合いをInputManagerから取得
        float swing = InputManager.instance.sidewaysMotion;

        // 適用する力を計算する
        Vector2 force = new Vector2(swing * swingSensitivity, 0);

        // 力を適用する
        GetComponent<Rigidbody2D>().AddForce(force);
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
