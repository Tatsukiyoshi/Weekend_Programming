import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class _Sample2Screen extends State<Sample2Screen>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
          title : const Text("サンプル(2)")
      ),
      body: SizedBox(
        width: double.infinity,
        height: double.infinity,
        child: CustomPaint(
          painter: RectPainter(),
        ),
      ),
    );
  }
}

class Sample2Screen extends StatefulWidget{

  const Sample2Screen({super.key});

  @override
  State createState() {
    return _Sample2Screen();
  }
}

class RectPainter extends CustomPainter{

  @override
  void paint(Canvas canvas, Size size) {

    // サイズの値は画面サイズ
    if (kDebugMode) {
      print("size is {$size}");
    }

    Paint paint1 = Paint()
      ..color = Colors.blue;

    // 0,0を画面の真ん中に移動する
    canvas.translate(size.width / 2, size.height / 2);

    Rect rect = Rect.fromCenter(center: Offset.zero,width: 100.0,height: 100.0);
    canvas.drawRect(rect, paint1);

    Paint paint2 = Paint()
      ..color = Colors.black;

    canvas.drawCircle(Offset.zero, 40, paint2);
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}