main(){
  // （1） 通常のListデータの定義
  List androidWidgets1 = [
    Widget("android1"),
    Widget("android2"),
  ];
  List children1 = [
    Widget("sample1"),
    ...androidWidgets1, // （2） ...を使った表現
    Widget("sample2")
  ];
  // 実行結果
  print(children1);
  // [sample1, android1, android2, sample2]
}
