import 'package:flutter/material.dart';

class RowWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        childContainer(50, 50),
        childContainer(100, 50),
        childContainer(50, 100),
        childContainer(100, 100),
      ],
    );
  }

  Widget childContainer(double width, double height) {
    return Container(
      margin: EdgeInsets.all(10),
      width: width,
      height: height,
      color: Colors.blue,
    );
  }
}
