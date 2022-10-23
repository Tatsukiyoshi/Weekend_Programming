import 'package:flutter/material.dart';

class Text2Widget extends StatelessWidget{

  @override
  Widget build(BuildContext context) {

    final textTheme = Theme.of(context).textTheme;

    final boldStyle = textTheme.bodyText1?.copyWith(
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
              style: textTheme.bodyText1,
            ),
            RichText(
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              text: TextSpan(
                  children: [
                    TextSpan(text : 'さあ', style: textTheme.bodyText1),
                    TextSpan(text : 'Flutter', style: boldStyle),
                    TextSpan(text : "を始めましょう", style: textTheme.bodyText1)
                  ]
              ),
            ),
          ],
        )
    );
  }
}
