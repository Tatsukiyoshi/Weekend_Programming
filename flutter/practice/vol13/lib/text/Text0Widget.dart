import 'package:flutter/material.dart';

class Text0Widget extends StatelessWidget{

  @override
  Widget build(BuildContext context) {

    return Container(
        color: Colors.white,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('Hello World')
          ])
    );
  }
}