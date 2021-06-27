using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;

// 6.1 シンプルなトラップ
// Playerがこのオブジェクトと衝突したときにUnityEventを発行する
[RequireComponent(typeof(Collider2D))]
public class SignalOnTouch : MonoBehaviour
{
    // 衝突したときに実行するUnityEvent
    // 実行するメソッドをエディタでアタッチする
    public UnityEvent onTouch;

    // もし真なら、衝突時にAudioSourceを再生するよう試みる
    public bool playAudioOnTouch = true;

    // もしトリガー領域に入ってきたなら、SendSignalを呼ぶ
    void OnTriggerEnter2D(Collider2D collider)
    {
        SendSignal(collider.gameObject);
    }

    // もしこのオブジェクトに衝突が起きたら、SendSignalを呼ぶ
    void OnCollisionEnter2D(Collision2D collision)
    {
        SendSignal(collision.gameObject);
    }

    // 衝突したオブジェクトがPlayerとしてタグ付けされているかを確認し、
    // もしそうならUnityEventを呼び出す
    void SendSignal(GameObject objectThatHit)
    {
        // Playerとタグ付けされているか？
        if (objectThatHit.CompareTag("Player"))
        {
            // もしサウンドを再生する必要があるなら、再生を試みる
            if (playAudioOnTouch)
            {
                var audio = GetComponent<AudioSource>();

                // もしaudioコンポーネントを持っていて、
                // その親がアクティブなら再生する
                if (audio &&
                    audio.gameObject.activeInHierarchy)
                    audio.Play();
            }

            // イベントの実行
            onTouch.Invoke();
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
