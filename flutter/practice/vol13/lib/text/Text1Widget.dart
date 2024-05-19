import 'package:flutter/material.dart';

class Text1Widget extends StatelessWidget{
  const Text1Widget({super.key});

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
        fontSize: 40
    );

    return Container(
      color: Colors.white,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text(
            'Hello World',
            textAlign: TextAlign.center,
            style: textStyle,
          ),
          RichText(
            maxLines: 1,
            overflow: TextOverflow.ellipsis,
            text: const TextSpan(
              children: [
                TextSpan(text : 'さあ', style: textStyle),
                TextSpan(text : 'Flutter', style: boldStyle),
                TextSpan(text : "を始めましょう", style: textStyle)
              ]
            ),
          ),
        ],
      )
    );
  }
}