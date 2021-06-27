using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// 5.2 ノームのコードのセットアップ
// 一定時間待ってからオブジェクトを取り除く
public class RemoveAfterDelay : MonoBehaviour
{
    // 取り除く前に何秒待つか
    public float delay = 1.0f;

    // Start is called before the first frame update
    void Start()
    {
        // Removeコルーチンを起動する
        StartCoroutine("Remove");
    }

    IEnumerator Remove()
    {
        // delay秒待ってから、このオブジェクトにアタッチされている
        // ゲームオブジェクトを破棄する
        yield return new WaitForSeconds(delay);
        Destroy(gameObject);

        // Destroy(this)とはしない。
        // それだとこのRemoveAfterDelayスクリプトが破棄される
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
