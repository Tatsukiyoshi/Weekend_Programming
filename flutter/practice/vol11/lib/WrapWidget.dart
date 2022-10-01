import 'package:flutter/material.dart';

class WrapWidget extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    var colors = [Colors.red, Colors.blue, Colors.green, Colors.amber];

    return Wrap(
      direction: Axis.vertical,
      spacing: 10,
      runSpacing: 40,
      children: [
        for(var i = 0; i < 3; i++)
        for(Color color in colors)
          childContainer(color)
      ],
    );
  }

  Widget childContainer(Color color) {
    return Container(
      width: 150,
      height: 150,
      color: color,
    );
  }
}