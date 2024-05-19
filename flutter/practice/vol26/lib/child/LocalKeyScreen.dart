import 'package:flutter/material.dart';
import 'package:vol26/child/TodoItemStatelessWidget.dart';
import 'package:vol26/child/TodoItemWidget.dart';

class _LocalKeyPage extends State<LocalKeyPage>{

  List<Widget> _items = [];
  bool _sort = false;

  @override
  void initState() {
    super.initState();
    _items.add(createTodoItemWidget(0,"タスク - 1"));
    _items.add(createTodoItemWidget(1,"タスク - 2"));
    _items.add(createTodoItemWidget(2,"タスク - 3"));
    _items.add(createTodoItemWidget(3,"タスク - 4"));
    _items.add(createTodoItemWidget(4,"タスク - 5"));
    _items.add(createTodoItemWidget(5,"タスク - 6"));
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
          title: const Text('ローカルキーサンプル'),
          actions : [
            IconButton(
                onPressed: (){
                  //  _itemsの順番を入れ替える
                  setState(() {
                    _sort =! _sort;
                    _items = List.from(_items.reversed);
                  });
                },
                icon: _sort? const Icon(Icons.arrow_circle_up) : const Icon(Icons.arrow_circle_down))
          ]
      ),
      body: Column(
        children: _items,
      ),
    );
  }

  Widget createTodoItemWidget(int no,String title){
    return TodoItemWidget(no, title,
        key: ValueKey(no)
    );
  }
}

class LocalKeyPage extends StatefulWidget{

  const LocalKeyPage({super.key});

  @override
  State createState() {
    return _LocalKeyPage();
  }
}