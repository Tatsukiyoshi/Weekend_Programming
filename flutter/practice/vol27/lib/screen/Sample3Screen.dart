import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class _Sample3Screen extends State<Sample3Screen>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
          title : const Text("サンプル(3)")
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

class Sample3Screen extends StatefulWidget{

  const Sample3Screen({super.key});

  @override
  State createState() {
    return _Sample3Screen();
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

    Path path1 = Path()
      ..moveTo(-100.0, 0.0)
      ..lineTo(100.0, 0.0)
      ..lineTo(0.0, -100.0)
      ..lineTo(-100.0, 0.0)
      ..close();

    canvas.drawPath(path1, paint1);

    Paint paint2 = Paint()
      ..color = Colors.black
      ..strokeWidth = 2.0
      ..style = PaintingStyle.stroke;

    Path path2 = Path()
      ..moveTo(-100.0, 0)
      ..lineTo(100.0, 0)
      ..lineTo(0, -100.0)
      ..lineTo(-100.0, 0)
      ..close();

    canvas.drawPath(path2, paint2);
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}