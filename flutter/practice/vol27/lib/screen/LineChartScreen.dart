import 'dart:math';

import 'package:flutter/material.dart';

class _LineChartScreen extends State<LineChartScreen>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
          title : const Text("ラインチャート")
      ),
      body: SizedBox(
        width: double.infinity,
        height: double.infinity,
        child: CustomPaint(
          painter: LineChartPainter(),
        ),
      ),
    );
  }
}

class LineChartScreen extends StatefulWidget{

  const LineChartScreen({super.key});

  @override
  State createState() {
    return _LineChartScreen();
  }
}

class LineChartPainter extends CustomPainter{

  @override
  void paint(Canvas canvas, Size size) {

    canvas.save();

    Paint paint1 = Paint()
      ..color = Colors.blue;

    // 0,0を画面の真ん中に移動する
    canvas.translate(20, size.height - 20);
    canvas.scale(1, -1);
    //canvas.save();

    for(double i = 0.0; i < size.width - 40; i = i + 20.0) {
      canvas.drawLine(Offset(i,0), Offset(i,size.height - 40) , paint1);
    }
    for(double i = 0.0; i < size.height - 40; i += 20.0){
      canvas.drawLine(Offset(0,i), Offset(size.width - 40,i) , paint1);
    }

    //  軸を記述する
    Paint paint2 = Paint()
      ..color = Colors.black
      ..strokeWidth = 3
      ..strokeCap = StrokeCap.square;

    canvas.drawLine(const Offset(0,0),Offset(size.width - 40,0),paint2);
    canvas.drawLine(const Offset(0,0),Offset(0,size.height - 40),paint2);

    Paint paint3 = Paint()
      ..color = Colors.red
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2
      ..strokeCap = StrokeCap.square;

    Path path = Path()
      ..moveTo(0.0, 0.0)
      ..lineTo(80.0, 140.0)
      ..lineTo(160.0, 60.0)
      ..lineTo(250.0, 430.0)
      ..lineTo(300.0, 130.0);
    
    canvas.drawPath(path, paint3);

    Paint paint4 = Paint()
      ..color = Colors.white;

    canvas.drawCircle(const Offset(80.0,140.0), 5, paint4);
    canvas.drawCircle(const Offset(160.0,60.0), 5, paint4);
    canvas.drawCircle(const Offset(250.0,430.0), 5, paint4);
    canvas.drawCircle(const Offset(300.0,130.0), 5, paint4);

    Paint paint5 = Paint()
      ..color = Colors.red
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2;

    canvas.drawCircle(const Offset(80.0,140.0), 5, paint5);
    canvas.drawCircle(const Offset(160.0,60.0), 5, paint5);
    canvas.drawCircle(const Offset(250.0,430.0), 5, paint5);
    canvas.drawCircle(const Offset(300.0,130.0), 5, paint5);

    canvas.restore();

    drawPointText(canvas, 80.0, 140.0, size);
    drawPointText(canvas, 160.0, 60.0, size);
    drawPointText(canvas, 250.0, 430.0, size);
    drawPointText(canvas, 300.0, 130.0, size);
  }

  /*
   *  座標のテキストを表示
   */
  void drawPointText(Canvas canvas,double x,double y, Size size){

    String label = "($x,$y)";

    TextSpan span = TextSpan(
        style: const TextStyle(
            color: Colors.black,
            fontWeight: FontWeight.bold,
            fontSize: 10
        ),
        children: [
          TextSpan(text: label)
        ]
    );

    TextPainter tp = TextPainter(
        text: span,
        textDirection: TextDirection.ltr
    );
    tp.layout(minWidth: 0,maxWidth: double.infinity);
    tp.paint(canvas, Offset(x + 20.0,( size.height - 40 ) - y));
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}