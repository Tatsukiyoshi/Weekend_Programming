import 'package:flutter/material.dart';

class Text3Widget extends StatelessWidget{
  const Text3Widget({super.key});


  @override
  Widget build(BuildContext context) {

    const textStyle = TextStyle(
        color: Colors.black54,
        fontWeight: FontWeight.normal,
        fontStyle: FontStyle.normal,
        decoration: TextDecoration.none,
        fontSize: 20
    );

    const boldStyle = TextStyle(
        color: Colors.redAccent,
        fontWeight: FontWeight.bold,
        fontStyle: FontStyle.normal,
        decoration: TextDecoration.none,
        fontSize: 50
    );

    return Container(
        color: Colors.white,
        child : const DefaultTextStyle(
          style: textStyle,
          child: Column (
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                'Hello World',
                textAlign: TextAlign.center,
              ),
              Text('さあ'),
              Text('Flutter',style: boldStyle),
              Text('をはじましょう')
            ]
          )
        )
    );
  }
}