import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:vol26/data/TodoItem.dart';

class _DraggableListViewPage extends State<DraggableListViewPage>{

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
    if (kDebugMode) {
      print("....build");
    }
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
          icon: _sort? const Icon(Icons.arrow_circle_down) : const Icon(Icons.arrow_circle_up))
        ]
      ),
      body: ReorderableListView.builder(
          itemCount: _items.length,
          itemBuilder: (context,index){
            return Container(
              key: UniqueKey(),
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
          }, onReorder: (int oldIndex, int newIndex){
            setState(() {
              final TodoItem item = _items.removeAt(oldIndex);
              _items.insert(newIndex,item);
            });
          },
      ),
    );
  }
}

class DraggableListViewPage extends StatefulWidget{

  const DraggableListViewPage({super.key});

  @override
  State createState() {
    return _DraggableListViewPage();
  }
}