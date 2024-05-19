import 'package:flutter/material.dart';
import 'package:vol9/sample2/second_page.dart';

class FirstPage extends StatelessWidget{
  const FirstPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title : const Text("ページ(1)")
      ),
      body : Center(
        child: TextButton(
          child: const Text("２ページに進む"),
          onPressed: (){
            Navigator.pushReplacement(
              context,
                MaterialPageRoute(
                  builder: (context) => const SecondPage(),
                )
            );
          },
        ),
      )
    );
  }
}
