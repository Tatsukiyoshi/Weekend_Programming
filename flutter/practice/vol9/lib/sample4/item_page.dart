import 'package:flutter/material.dart';

class ItemPage extends StatelessWidget{

  final String id;

  const ItemPage({super.key,
    required this.id
  });

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: const Text("アイテムページ"),
      ),
      body: Center(
        child: Text("本文 - $id"),
      ),
    );
  }
}
