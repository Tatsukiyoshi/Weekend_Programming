import 'package:flutter/material.dart';

class Text2Widget extends StatelessWidget{
  const Text2Widget({super.key});


  @override
  Widget build(BuildContext context) {

    final textTheme = Theme.of(context).textTheme;

    final boldStyle = textTheme.bodyLarge?.copyWith(
      color: Colors.redAccent,
      fontSize: 40,
      fontWeight: FontWeight.bold
    );

    return Container(
        color: Colors.white,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Hello World',
              textAlign: TextAlign.center,
              style: textTheme.bodyLarge,
            ),
            RichText(
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              text: TextSpan(
                  children: [
                    TextSpan(text : 'さあ', style: textTheme.bodyLarge),
                    TextSpan(text : 'Flutter', style: boldStyle),
                    TextSpan(text : "を始めましょう", style: textTheme.bodyLarge)
                  ]
              ),
            ),
          ],
        )
    );
  }
}
