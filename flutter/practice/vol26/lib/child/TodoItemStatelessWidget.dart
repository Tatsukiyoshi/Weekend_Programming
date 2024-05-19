import 'package:flutter/material.dart';

class TodoItemStatelessWidget extends StatelessWidget{

  final int no;
  final String title;

  const TodoItemStatelessWidget(this.no, this.title, {super.key});

  @override
  Widget build(BuildContext context) {
    var child = Container(
      decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(10),
          border : Border.all(
              color: Colors.blue
          )
      ),
      margin: const EdgeInsets.all(5),
      height: 50,
      child: Center(
        child: Text(title),
      ),
    );
    return child;
  }
}