import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class PaddingWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20),
      child: Container(
        width: 500,
        height: 500,
        color: Colors.blue,
      ),
    );
  }
}
