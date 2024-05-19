import 'package:flutter/material.dart';

class Text0Widget extends StatelessWidget{
  const Text0Widget({super.key});


  @override
  Widget build(BuildContext context) {

    return Container(
        color: Colors.white,
        child: const Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('Hello World')
          ])
    );
  }
}