import 'package:flutter/material.dart';

class AspectRatioWidget extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    return AspectRatio(
        aspectRatio: 16/9,
        child: Container(
          margin: EdgeInsets.all(20),
          color: Colors.blue,
        ),
    );
  }

}