using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;

// 5.3 ゲームマネージャーのセットアップ
// オブジェクトの状態をリセットするのに用いるUnityEventを含む
public class Resettable : MonoBehaviour
{
    // エディタにて、ゲームをリセットしたときに呼び出すメソッドを
    // このイベントに接続する
    public UnityEvent onReset;

    // ゲームがリセットするときにGameManegerから呼ばれる
    public void Reset()
    {
        // すべての接続されたメソッドを呼ぶイベントを実行する
        onReset.Invoke();
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
