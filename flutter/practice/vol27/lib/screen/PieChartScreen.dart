import 'dart:math';

import 'package:flutter/material.dart';

class _PieChartScreen extends State<PieChartScreen>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
          title : const Text("パイチャート")
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

class PieChartScreen extends StatefulWidget{

  const PieChartScreen({super.key});

  @override
  State createState() {
    return _PieChartScreen();
  }
}

class RectPainter extends CustomPainter{

  @override
  void paint(Canvas canvas, Size size) {

    canvas.translate(size.width / 2, size.height /2);
    double minSize = min(size.width, size.height);
    canvas.scale(minSize/650);
    canvas.save();

    Paint paint1 = Paint()
      ..color = Colors.red;

    var rect = Rect.fromCenter(
      center: const Offset(0, 0),
      height: 600,
      width: 600,
    );

    canvas.drawArc(rect, pi * ( -90 / 180), (pi * 2) * ( 100 / 360 ) , true, paint1);

    Paint paint2 = Paint()
      ..color = Colors.green;

    canvas.drawArc(rect, pi * ( (100 - 90) / 180 ) , (pi * 2) * ( 140 / 360 ) , true, paint2);

    Paint paint3 = Paint()
      ..color = Colors.blue;
    canvas.drawArc(rect,  (pi *  ( 240 - 90 ) / 180 ) , (pi * 2) * ( 120 / 360 ) , true, paint3);

    Paint paint4 = Paint()
      ..color = Colors.white;
    canvas.drawCircle(Offset.zero, 100, paint4);

    canvas.restore();
    canvas.scale(1,-1);

    Paint drawLine = Paint()
      ..color = Colors.white
      ..strokeWidth = 5;

    canvas.drawLine(Offset.zero, const Offset(0.0, 300), drawLine);
    canvas.drawLine(Offset.zero, piOffset(300, 100),drawLine);
    canvas.drawLine(Offset.zero, piOffset(300, (100 + 140)),drawLine);
  }

  Offset piOffset(double r,double rad){
    double x = r * cos( pi * ( 90 - rad) / 180);
    double y = r * sin( pi * ( 90 - rad) / 180);
    return Offset( x, y );
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}