main(){
    var isAndroid = false;
    var isIos = true;

    var appends = [Widget("append1"),Widget("append2")];

    List children = [
    Widget("sample1"),
    // （1） ifを記述
    if(isAndroid)
        AndroidWidget("sample2")
    // elseでさらに条件を追加
    else if(isIos)
        IOSWidget("ios1")
    //  （2）複数を追加したい場合にはspreads表現を組み合わせる
    else
        ...appends,
        Widget("sample3")
    ];
    print(children);
    // [sample1, ios1, sample3]

    // 参考 : isAndroid = true, isIos = false の場合の結果
    // [sample1, sample2, sample3]

    // 参考 : isAndroid = false , isIos= false の場合の結果
    // [sample1, append1, append2, sample3]
}
