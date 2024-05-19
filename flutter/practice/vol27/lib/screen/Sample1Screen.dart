import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class _Sample1Screen extends State<Sample1Screen>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
        title : const Text("サンプル(1)")
      ),
      body: SizedBox(
        width: double.infinity,
        height: double.infinity,
        child: CustomPaint(
          painter: SamplePainter(),
        ),
      ),
    );
  }
}

class Sample1Screen extends StatefulWidget{

  const Sample1Screen({super.key});

  @override
  State createState() {
    return _Sample1Screen();
  }
}

class SamplePainter extends CustomPainter{

  @override
  void paint(Canvas canvas, Size size) {

    // サイズの値は画面サイズ
    if (kDebugMode) {
      print("size is {$size}");
    }

    Paint paint = Paint()
        ..color = Colors.red;

    //  マージン10にでの画面一杯の四角
    Rect rect1 = const Offset(20.0, 20.0) & Size(size.width - 40.0,size.height - 40.0);
    canvas.drawRect(rect1, paint);

    //
    Paint paint2 = Paint()
      ..color = Colors.blue;

    Rect rect2 = Rect.fromLTWH(size.width / 2 - 50.0, size.height / 2 - 50.0, 100.0, 100.0);
    canvas.drawRect(rect2, paint2);

    Paint paint3 = Paint()
      ..color = Colors.black;

    canvas.drawCircle(Offset(size.width/2,size.height/2), 40, paint3);
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}