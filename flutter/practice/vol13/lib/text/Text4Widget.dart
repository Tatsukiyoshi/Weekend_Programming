import 'package:flutter/material.dart';

class Text4Widget extends StatelessWidget{
  const Text4Widget({super.key});


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
            Container(
              height: 20,
            ),
            RichText(
              text: TextSpan(
                  children: [
                    TextSpan(text : 'さあ', style: textTheme.bodyLarge),
                    WidgetSpan(
                      child : SizedBox(
                        height: 40,
                        child: Image.asset('assets/images/logo_flutter_horizontal.png'),
                      )
                    ),
                    TextSpan(text : "を始めましょう", style: textTheme.bodyLarge)
                  ]
              ),
            ),
            Container(
              height: 20,
            ),
            RichText(
              text: TextSpan(
                  children: [
                    TextSpan(text : 'さあ', style: textTheme.bodyLarge),
                    WidgetSpan(
                        alignment: PlaceholderAlignment.middle,
                        child : SizedBox(
                          height: 40,
                          child: Image.asset('assets/images/logo_flutter_horizontal.png'),
                        )
                    ),
                    TextSpan(text : "を始めましょう", style: textTheme.bodyLarge)
                  ]
              ),
            ),
          ],
        )
    );
  }
}