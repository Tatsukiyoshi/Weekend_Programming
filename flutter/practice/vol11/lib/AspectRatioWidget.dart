import 'package:flutter/material.dart';

class AspectRatioWidget extends StatelessWidget{
  const AspectRatioWidget({super.key});

  @override
  Widget build(BuildContext context) {

    return AspectRatio(
        aspectRatio: 16/9,
        child: Container(
          margin: const EdgeInsets.all(20),
          color: Colors.blue,
        ),
    );
  }

}