import 'package:flutter/material.dart';

class CenterWidget extends StatelessWidget{
  const CenterWidget({super.key});


  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        color: Colors.deepOrange,
        width: 200,
        height: 200,
        margin: const EdgeInsets.all(20),
      ),
    );
  }
}
