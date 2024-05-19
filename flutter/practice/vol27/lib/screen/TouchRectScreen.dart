import 'dart:math';
import 'dart:ui' as ui;

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class _TouchRectScreen extends State<TouchRectScreen>{

  bool _hasImage = false;
  ui.Image? image;

  final TapRectController _touchRectController = TapRectController();

  @override
  void initState(){
    super.initState();
    final Future<ByteData> f = rootBundle.load("assets/image.jpg");
    f.then((value) async {
      image = await decodeImageFromList(value.buffer.asUint8List());
      setState(() {
        _hasImage = true;
      });
    });
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar : AppBar(
          title : const Text("タッチスクリーン")
      ),
      body: GestureDetector(
        onLongPressStart: _onTapStart,
        onLongPressEnd: _onTapEnd,
        onLongPressMoveUpdate: _onTapMove,
        child: childWidget()
      )
    );
  }

  Widget childWidget(){
    if(_hasImage){
      _touchRectController.image = image;
      return SizedBox(
          width: double.infinity,
          height: double.infinity,
          child: CustomPaint(
            painter: BackgroundPainter(image!),
            foregroundPainter: TouchRectPainter(_touchRectController),
          )
      );
    }
    else{
      return Container();
    }
  }

  _onTapStart(LongPressStartDetails tap){
    if (kDebugMode) {
      print("start long tap ${tap.localPosition} - $tap");
    }
    setState(() {
      _touchRectController.start = tap.localPosition;
    });
  }

  _onTapEnd(LongPressEndDetails tap){

    Future<ui.Image> f  = _touchRectController.onChopRequest();
    f.then((value) => {
      setState((){
        image = value;
        _touchRectController.start = null;
        _touchRectController.end = null;
      })
    });
  }

  _onTapMove(LongPressMoveUpdateDetails tap) async {
    setState(() {
      _touchRectController.end = tap.localPosition;
    });
  }
}

class TapRectController{

  Size? screen;
  Offset? start;
  Offset? end;

  ui.Image? image;

  TapRectController();

  Future<ui.Image> onChopRequest() async {
    double minScale = min(screen!.width / image!.width, screen!.height / image!.height);
    double upScale = 1 / minScale;

    var pictureRecorder = ui.PictureRecorder();
    ui.Canvas canvas = ui.Canvas(pictureRecorder);

    Rect chopSrc = Rect.fromLTRB(start!.dx * upScale, start!.dy * upScale, end!.dx * upScale, end!.dy * upScale);
    Rect chopDst = Rect.fromLTRB(0, 0,( end!.dx - start!.dx ) * upScale, ( end!.dy - start!.dy ) * upScale);

    canvas.drawImageRect(image!,
        chopSrc,
        chopDst,
        Paint()
    );

    int w = ((end!.dx - start!.dx) * upScale).toInt();
    int h = ((end!.dy - start!.dy) * upScale).toInt();

    if (kDebugMode) {
      print("w,h -> ${image!.width} ${image!.height} -> $w , $h");
    }

    ui.Image newImage = await pictureRecorder.endRecording().toImage(w,h);
    return newImage;
  }
}

class TouchRectScreen extends StatefulWidget{

  const TouchRectScreen({super.key});

  @override
  State createState() {
    return _TouchRectScreen();
  }
}


class BackgroundPainter extends CustomPainter{
  final ui.Image _image;

  BackgroundPainter(this._image);

  @override
  void paint(ui.Canvas canvas, ui.Size size) {
    double minScale = min(size.width / _image.width, size.height / _image.height);
    canvas.scale(minScale);
    canvas.drawImage(_image, Offset.zero, Paint());
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}

class TouchRectPainter extends CustomPainter{

  final TapRectController _controller;
  TouchRectPainter(this._controller);

  @override
  void paint(Canvas canvas, Size size) {

    _controller.screen = size;

    Paint paint1 = Paint()
      ..color = const Color.fromRGBO(255, 255, 255, 0.5);

    if(_controller.start != null && _controller.end != null){
      Rect rect = Rect.fromPoints(_controller.start!, _controller.end!);
      canvas.drawRect(rect, paint1);
    }
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return true;
  }
}