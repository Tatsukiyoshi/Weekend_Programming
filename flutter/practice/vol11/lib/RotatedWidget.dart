import 'package:flutter/material.dart';

class RotatedWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return RotatedBox(
      quarterTurns: 1,
      child: Container(width: 300, height: 200, color: Colors.blue),
    );
  }
}
