import 'package:flutter/material.dart';

class AlignWidget extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Align(
      alignment: Alignment.topRight,
      child: Container(
        width: 200,
        height: 200,
        color: Colors.blue,
      ),
    );
  }

}