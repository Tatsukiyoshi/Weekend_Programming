using UnityEngine;
using System.Collections;

// 5.1.4 InputManagerシングルトンの実装
// 加速度センサーの値を左右方向に揺らすための情報に変換
public class InputManager : Singleton<InputManager>
{
    // どれくらい移動しているか
    // -1.0は完全に左。+1.0は完全に右を表す
    private float _sidewaysMotion = 0.0f;

    // このプロパティは読み取り専用で宣言されているので、
    // 他のクラスはこれを変更できない
    public float sidewaysMotion
    {
        get
        {
            return _sidewaysMotion;
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    // 毎フレーム傾きを格納する
    void Update()
    {
        Vector3 accel = Input.acceleration;

        _sidewaysMotion = accel.x;
    }
}
