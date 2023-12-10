import 'package:flutter_test/flutter_test.dart';

void main() {
  // 成功するケース
  test("mytest1", () {
    int ans = 10;
    expect(ans, 10);
  });

  // 失敗するケース
  test("mytest2", () {
    int ans = 10;
    expect(ans, 15);
  });

  // スキップするテストケース
  test("mytest3", () {
    int ans = 0;
    expect(ans, 100);
  }, skip: "一旦スキップ");
}
