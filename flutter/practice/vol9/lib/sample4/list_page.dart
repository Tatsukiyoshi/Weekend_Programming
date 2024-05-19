import 'package:flutter/material.dart';

class ListItem{
  final int id;
  ListItem(this.id);
}

class ListPage extends StatelessWidget{
  const ListPage({super.key});

  @override
  Widget build(BuildContext context) {

    List<ListItem> items = [
      ListItem(1),
      ListItem(2),
      ListItem(3),
      ListItem(4),
      ListItem(5),
      ListItem(6)
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text("一覧"),
      ),
      body: ListView(
        children: [
          for(var item in items)
            ListTile(
              title: Text("Item is ${item.id}"),
              onTap: () => {
                Navigator.pushNamed(context, "/detail/${item.id}")
              },
            )
        ],
      ),
    );
  }
}
