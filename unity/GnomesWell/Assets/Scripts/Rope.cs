using System.Collections;
using System.Collections.Generic;
using UnityEngine;

//
// 4.4.1 ロープのコーディング
//
public class Rope : MonoBehaviour
{
    // 使用するRope Segement プレハブ
    public GameObject ropeSegmentPrefab;

    // Rope Segmentオブジェクトのリストを格納
    List<GameObject> ropeSegments = new List<GameObject>();

    // 現在ロープを伸ばしているのか？それとも縮めているのか？
    public bool isIncreasing { get; set; }
    public bool isDecreasing { get; set; }

    // ロープの末端が繋がるリジットボディオブジェクト
    public Rigidbody2D connectedObject;

    // ロープの一つのセグメントの最大の長さ
    // （これより伸ばしたい場合は新しいセグメントを生成する）
    public float maxRopeSegementLength = 1.0f;

    // 新しいロープを準備する速さ
    public float ropeSpeed = 4.0f;

    // ロープを描画するLineRenderer
    LineRenderer lineRenderer;

    // Start is called before the first frame update
    void Start()
    {
        // 毎フレーム読み込まないために、LineRendererを取得しておく
        lineRenderer = GetComponent<LineRenderer>();

        // 初めにロープの状態をリセットしておく
        ResetLength();
    }

    // ロープのすべてのセグメントを破棄した上で、新しいセグメントを一つ作る
    public void ResetLength()
    {
        foreach (GameObject segment in ropeSegments)
        {
            Destroy(segment);
        }

        ropeSegments = new List<GameObject>();

        isDecreasing = false;
        isIncreasing = false;

        CreateRopeSegment();
    }

    // ロープの先端に新しいセグメントを追加する
    void CreateRopeSegment()
    {
        // 新しいセグメントを作成
        GameObject segment = (GameObject)Instantiate(
            ropeSegmentPrefab,
            this.transform.position,
            Quaternion.identity);

        // ロープのセグメントのワールド座標の位置を保ったまま、
        // このオブジェクトの子に設定する
        segment.transform.SetParent(this.transform, true);

        // セグメントからRigidBodyを取得
        Rigidbody2D segmentBody = segment.GetComponent<Rigidbody2D>();

        // セグメントからジョイントを取得
        SpringJoint2D segmentJoint =
            segment.GetComponent<SpringJoint2D>();

        // もしセグメントのプレハブがRigidbodyかSpringJointのいずれかを
        // 持っていなければエラーにする。両方が必要
        if (segmentBody == null || segmentJoint == null)
        {
            Debug.LogError("Rope segment body prefab has no " +
                "Rigidbody2D and/or SpringJoint2D!");
            return;
        }

        // チェックが通ったら、ロープのセグメントのリストの先頭に追加する
        ropeSegments.Insert(0, segment);

        // もし最初のセグメントなら、ノームに接続する
        if (ropeSegments.Count == 1)
        {
            // connectedObjectが持つジョイントに接続する
            SpringJoint2D connectedObjectJoint = connectedObject.GetComponent<SpringJoint2D>();
            connectedObjectJoint.connectedBody = segmentBody;
            connectedObjectJoint.distance = 0.1f;

            // このジョイントを最大値で伸びきった状態にする
            segmentJoint.distance = maxRopeSegementLength;
        }
        else
        {
            // これは２つ目以降のロープのセグメントになる
            // 現在のロープの先端のセグメントに接続する

            // ２番目のセグメントを取得する
            GameObject nextSegment = ropeSegments[1];

            // 接続する対象のジョイントを取得する
            SpringJoint2D nextSegmentJoint = nextSegment.GetComponent<SpringJoint2D>();

            // 取得したジョイントが最後のセグメントに接続する
            nextSegmentJoint.connectedBody = segmentBody;

            // このジョイントと前回のジョイントの距離を０にする
            // あとで伸ばされる
            segmentJoint.distance = 0.0f;
        }

        // 新しいセグメントをロープ（つまりこのオブジェクト）のアンカーに接続する
        segmentJoint.connectedBody = this.GetComponent<Rigidbody2D>();
    }

    // ロープを縮小させる時と、ロープのセグメントを取り払うときに呼ぶ
    void RemoveRopeSegment()
    {
        // セグメントが２つ以上存在しない場合は終了する
        if (ropeSegments.Count < 2)
        {
            return;
        }

        // 先頭とその次のセグメントを取得する
        GameObject topSegment = ropeSegments[0];
        GameObject nextSegment = ropeSegments[1];

        // ２番目のセグメントをロープのアンカーにセットする
        SpringJoint2D nextSegmentJoint = nextSegment.GetComponent<SpringJoint2D>();
        nextSegmentJoint.connectedBody = this.GetComponent<Rigidbody2D>();

        // 先頭のセグメントを取り外して破棄する
        ropeSegments.RemoveAt(0);
        Destroy(topSegment);
    }

    // Update is called once per frame
    // 毎フレーム、必要ならロープを伸ばしたり縮めたりする
    void Update()
    {
        // 先頭のセグメントと、それに付いていジョイントを取得する
        GameObject topSegment = ropeSegments[0];
        SpringJoint2D topSegmentJoint = topSegment.GetComponent<SpringJoint2D>();

        if (isIncreasing)
        {
            // ロープを伸ばす。
            // もし、セグメントの長さが最大なら、新しいセグメントを追加する
            // そうでなければ、先端のセグメントの長さを伸ばす
            if (topSegmentJoint.distance >= maxRopeSegementLength)
            {
                CreateRopeSegment();
            }
            else
            {
                topSegmentJoint.distance += ropeSpeed * Time.deltaTime;
            }
        }

        if (isDecreasing)
        {
            // ロープを縮める
            // もしセグメントの長さがほぼ０なら、そのセグメントを破棄する
            // そうでなければ、先端のセグメントの長さを短くする
            if (topSegmentJoint.distance <= 0.005f)
            {
                RemoveRopeSegment();
            }
            else
            {
                topSegmentJoint.distance -= ropeSpeed * Time.deltaTime;
            }
        }

        if (lineRenderer != null)
        {
            // LineRendererは点の集合をもとに線を描画する
            // この点はロープのセグメントの位置と同期している必要がある

            // LineRendererの頂点の数は、ロープのセグメントの数と
            // ロープの先端のアンカーポイントと、ノームの足元のポイントを
            // 合計した数になる
            lineRenderer.positionCount = ropeSegments.Count + 2;

            // 先端の頂点はいつもロープの位置にある
            lineRenderer.SetPosition(0, this.transform.position);

            // lineRendererの頂点はすべてのロープのセグメントの位置に対応するようにする
            for (int i = 0; i < ropeSegments.Count; i++)
            {
                lineRenderer.SetPosition(i + 1, ropeSegments[i].transform.position);
            }

            // 最後の頂点は接続されるオブジェクトのアンカーの位置にある
            SpringJoint2D connectedObjectJoint = connectedObject.GetComponent<SpringJoint2D>();
            lineRenderer.SetPosition(ropeSegments.Count + 1, connectedObject.transform.TransformPoint(connectedObjectJoint.anchor));
        }
    }
}
