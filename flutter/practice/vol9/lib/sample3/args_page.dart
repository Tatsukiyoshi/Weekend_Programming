import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class PageArguments{
  final String message;
  PageArguments(this.message);
}

class ArgsPage extends StatelessWidget{
  const ArgsPage({super.key});

  @override
  Widget build(BuildContext context) {
    //  引数を取得する
    final PageArguments args = ModalRoute.of(context)?.settings.arguments as PageArguments;
    if (kDebugMode) {
      print(args.message);
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text("引数ページ"),
      ),
      body: Center(
        child: Text(args.message),
      ),
    );
  }
}
