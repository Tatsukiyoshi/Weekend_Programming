import 'dart:math';

import 'package:flutter/material.dart';

class _PathCombineScreen extends State<PathCombineScreen>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
          title : const Text("パスの合成")
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

class PathCombineScreen extends StatefulWidget{

  const PathCombineScreen({super.key});

  @override
  State createState() {
    return _PathCombineScreen();
  }
}

class RectPainter extends CustomPainter{

  @override
  void paint(Canvas canvas, Size size) {


    Paint paint = Paint()
      ..color = Colors.blue;


    canvas.save();

    canvas.translate(100, size.height /2);
    canvas.scale(1, -1);

    Path path1 = Path();

    var rect1 = Rect.fromCenter(
      center: const Offset(-20, 0),
      height: 100,
      width: 100,
    );

    path1.addArc(rect1, 0, pi * 2);

    Path path2 = Path();

    var rect2 = Rect.fromCenter(
      center: const Offset(20, 0),
      height: 100,
      width: 100,
    );

    path2.addArc(rect2, 0, pi * 2);

    Path path = Path.combine(PathOperation.union, path1, path2);
    canvas.drawPath(path, paint);

    canvas.restore();
    canvas.save();

    canvas.translate(250, size.height /2);
    canvas.scale(1, -1);
    canvas.drawPath(Path.combine(PathOperation.intersect, path1, path2), paint);

    canvas.restore();
    canvas.save();

    canvas.translate(400, size.height /2);
    canvas.scale(1, -1);
    canvas.drawPath(Path.combine(PathOperation.xor, path1, path2), paint);

    canvas.restore();
    canvas.save();

    canvas.translate(600, size.height /2);
    canvas.scale(1, -1);
    canvas.drawPath(Path.combine(PathOperation.difference, path1, path2), paint);

    canvas.restore();

    canvas.save();

    canvas.translate(650, size.height /2);
    canvas.scale(1, -1);
    canvas.drawPath(Path.combine(PathOperation.reverseDifference, path1, path2), paint);

    canvas.restore();
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}