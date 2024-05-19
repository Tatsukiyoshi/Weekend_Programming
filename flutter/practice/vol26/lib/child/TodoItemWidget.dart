import 'package:flutter/material.dart';

class _TodoItemWidget extends State<TodoItemWidget>{

  late int no;
  late String title;

  @override
  void initState() {
    super.initState();
    setState(() {
      no = widget.no;
      title = widget.title;
    });
  }

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
class TodoItemWidget extends StatefulWidget{

  final int no;
  final String title;

  const TodoItemWidget(this.no, this.title, {super.key});

  @override
  State createState() {
    return _TodoItemWidget();
  }
}