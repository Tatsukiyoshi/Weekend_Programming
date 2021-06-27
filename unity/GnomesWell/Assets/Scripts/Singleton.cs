using UnityEngine;
using System.Collections;

// 5.1.3 シングルトンクラスの作成

// このクラスは他のオブジェクトが単一の共有オブジェクトを
// 参照することを実現する。
// GameManagerクラスとInputManagerクラスがこれを使用する

// これを使うためのサブクラスの宣言は以下のようになる
// public class MyManager : Singleton<MyManager> { }

// そのあと、クラスの単一の共有インスタンスには以下のようにアクセスできる
// MyManager.instance.Dosomething();

public class Singleton<T> : MonoBehaviour
    where T : MonoBehaviour
{
    // このクラスの単一のインスタンス
    private static T _instance;

    // アクセサー。初めてこれが呼ばれたときに _instanceが準備される
    // 適切なオブジェクトが見つからない場合はエラーをログに出力する
    public static T instance
    {
        get
        {
            // もしまだ_instanceが準備されていないなら
            if(_instance == null)
            {
                // オブジェクトを探す
                _instance = FindObjectOfType<T>();

                // 見つけられないときはログに出力する
                if(_instance == null)
                {
                    Debug.LogError("Can't find " + typeof(T) + "!");
                }
            }

            // インスタンスが使えるので、リターンする
            return _instance;
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
