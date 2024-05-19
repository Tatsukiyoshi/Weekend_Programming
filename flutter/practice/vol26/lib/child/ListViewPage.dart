import 'package:flutter/material.dart';
import 'package:vol26/data/TodoItem.dart';

class _ListViewPage extends State<ListViewPage>{

  List<TodoItem> _items = [];
  bool _sort = false;

  @override
  void initState() {
    super.initState();
    _items.add(TodoItem(0,"タスク - 1"));
    _items.add(TodoItem(1,"タスク - 2"));
    _items.add(TodoItem(2,"タスク - 3"));
    _items.add(TodoItem(3,"タスク - 4"));
    _items.add(TodoItem(4,"タスク - 5"));
    _items.add(TodoItem(5,"タスク - 6"));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('タスク一覧'),
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
      body: ListView.builder(
          itemCount: _items.length,
          itemBuilder: (context,index){
            return Container(
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(10),
                border : Border.all(
                  color: Colors.blue
                )
              ),
              margin: const EdgeInsets.all(5),
              height: 50,
              child: Center(
                child: Text(_items[index].title),
              ),
            );
          },
      ),
    );
  }
}


class ListViewPage extends StatefulWidget{

  const ListViewPage({super.key});

  @override
  State createState() {
    return _ListViewPage();
  }
}