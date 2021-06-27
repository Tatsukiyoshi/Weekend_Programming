using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// 5.1.6 カメラがノームに追従するようにする
public class CameraFollow : MonoBehaviour
{
    // Y座標を合わせたいオブジェクト
    public Transform target;

    // カメラの位置の上限
    public float topLimit = 10.0f;

    // カメラの位置の下限
    public float bottomLimit = -10.0f;

    // ターゲットの方にどれくらいの速度で移動するか？
    public float followSpeed = 0.5f;

    // すべてのオブジェクトの位置が更新されたら、
    // このカメラの位置を更新する
    void LateUpdate()
    {
        // もし、ターゲットがあるなら
        if(target != null)
        {
            // このオブジェクトの位置を取得
            Vector3 newPosition = this.transform.position;

            // このカメラがどの位置にあるべきかを計算する
            newPosition.y = Mathf.Lerp(newPosition.y, target.position.y, followSpeed);

            // 新しい位置を制限内に収める
            newPosition.y = Mathf.Min(newPosition.y, topLimit);
            newPosition.y = Mathf.Max(newPosition.y, bottomLimit);

            // 位置を更新する
            transform.position = newPosition;
        }
    }

    // エディタで選択されたときに上限から下限に線を引く
    void OnDrawGizmoSelected()
    {
        Gizmos.color = Color.yellow;

        Vector3 topPoint = new Vector3(this.transform.position.x,
            topLimit, this.transform.position.z);

        Vector3 bottomPoint = new Vector3(this.transform.position.x,
            bottomLimit, this.transform.position.z);

        Gizmos.DrawLine(topPoint, bottomPoint);
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
