import 'package:vol22/page/LoginPage.dart';
import 'package:flutter/material.dart';

class WelcomePage extends StatelessWidget{
  const WelcomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Chat App'),
        actions: [
          IconButton(onPressed: (){
            Navigator.of(context).pushReplacement(MaterialPageRoute(builder: (context){
              return const LoginPage();
            }));
          }, icon: const Icon(Icons.logout))
        ],
      ),
      body: Container(

      ),
    );
  }
}