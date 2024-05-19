import 'package:flutter/material.dart';
import 'package:vol26/logger/LoggerWidget.dart';

class _LoggerPage extends State<LoggerPage>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          title: const Text('ログサンプル'),
          actions : [
            IconButton(
                onPressed: (){
                  LoggerWidget.of(context)?.d("pressed");
                },
                icon: const Icon(Icons.edit)
            )
          ]
      ),
      body: Container(

      ),
    );
  }
}

class LoggerPage extends StatefulWidget{

  const LoggerPage({super.key});

  @override
  State createState() {
    return _LoggerPage();
  }
}