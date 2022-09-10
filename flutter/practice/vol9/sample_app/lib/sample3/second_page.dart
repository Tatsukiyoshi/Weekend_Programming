import 'package:flutter/material.dart';
import 'package:sample_app/sample3/args_page.dart';

class SecondPage extends StatelessWidget{
  const SecondPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("ページ（2）"),
      ),
      body: Center(
        child: TextButton(
          child: const Text("引数ページへ"),
          onPressed: (){
            Navigator.pushNamed(context, "/args",
              arguments: PageArguments("こんにちは！"));
          },
        ),
      ),
    );
  }
}
