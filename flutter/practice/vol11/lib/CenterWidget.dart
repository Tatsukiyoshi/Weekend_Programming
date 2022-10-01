import 'package:flutter/material.dart';

class CenterWidget extends StatelessWidget{

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        color: Colors.deepOrange,
        width: 200,
        height: 200,
        margin: EdgeInsets.all(20),
      ),
    );
  }
}
