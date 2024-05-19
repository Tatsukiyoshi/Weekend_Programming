import 'package:flutter/material.dart';

class FirstPage extends StatelessWidget{
  const FirstPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("ページ（1）"),
      ),
      body: Center(
        child: TextButton(
          child: const Text("Second Page"),
          onPressed: (){
            Navigator.pushNamed(context, '/second');
          },
        ),
      ),
    );
  }
}
