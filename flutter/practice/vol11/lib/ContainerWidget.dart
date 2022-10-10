import 'package:flutter/material.dart';

class ContainerWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return customDecorationContainer();
  }

  Container basicContainer() {
    return Container(
        width: 350,
        height: 350,
        color: Colors.green,

        child: Container(
          child: Container( color: Colors.white ),

          color: Colors.blue,
          width: 300,
          height: 300,
          padding: EdgeInsets.all(30),
          margin: EdgeInsets.all(50),
          alignment: Alignment.center,
    ));
  }

  Container borderContainer() {
    return Container(
        child: Text("Hello"),
        // (1) 色の指定はできません
        // color : Colors.white,
        width: 300,
        height: 300,
        alignment: Alignment.center,
        decoration: BoxDecoration(
            color: Colors.white,
            border: Border.all(width: 15.0, color: Colors.blue)));
  }

  Container customDecorationContainer() {
    return Container(
        child: Text("Hello"),
        // (1) 色の指定はできません
        // color : Colors.white,
        width: 300,
        height: 300,
        alignment: Alignment.center,
        decoration: roundBoxDecoration()
    );
  }

  Container customMarginPaddingContainer() {
    return Container(
        width: 350,
        height: 350,
        color: Colors.green,

        child: Container(
          child: Container( color: Colors.white ),
          color: Colors.blue,
          width: 300,
          height: 300,
          padding: createPadding(),
          margin: createMargin(),
          alignment: Alignment.center,
        ));
  }

  // 上下右左を個別に指定する
  EdgeInsets createMargin() {
    return EdgeInsets.only(left: 10.0, top: 20.0, right: 30.0, bottom: 40.0);
  }

  //
  EdgeInsets createPadding() {
    return EdgeInsets.symmetric(vertical: 10.0, horizontal: 20.0);
  }

  ///  背景と枠を表示する
  BoxDecoration basicBoxDecoration() {
    return BoxDecoration(
        color: Colors.white,
        border: Border.all(width: 5.0, color: Colors.blue));
  }

  /// 枠に丸みを持たせる
  BoxDecoration roundBoxDecoration() {
    return BoxDecoration(
        color: Colors.white,
        border: Border.all(width: 5.0, color: Colors.blue),
        borderRadius: BorderRadius.circular(50),
        boxShadow: [
          BoxShadow(blurRadius: 20)
        ]);
  }

  /// まるい形にする
  BoxDecoration circleBoxDecoration() {
    return BoxDecoration(
        color: Colors.white,
        shape: BoxShape.circle,
        border: Border.all(width: 5.0, color: Colors.blue),
        boxShadow: [BoxShadow(blurRadius: 20)]);
  }
}
