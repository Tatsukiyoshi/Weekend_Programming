import 'package:flutter/material.dart';

class PopupMenuButtonWidget extends StatelessWidget{
  const PopupMenuButtonWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: createPopupMenuButton1()
      )
    );
  }

  PopupMenuButton createPopupMenuButton1(){
    return PopupMenuButton(
      itemBuilder: (BuildContext context) => <PopupMenuEntry>[
        const PopupMenuItem(
            child: ListTile(
                leading: Icon(Icons.add),
                title : Text('追加')
            )
        ),
        const PopupMenuItem(
          child: ListTile(
              leading: Icon(Icons.delete),
              title : Text('削除')
          ),
        ),
        const PopupMenuDivider(),
        const PopupMenuItem(
            child : ListTile(
                title : Text("その他")
            )
        )
      ],
    );
  }

  Widget createActionButton(){
    final isSelected = <bool>[false, false];
    return ToggleButtons(
      isSelected: isSelected,
      onPressed: (index){},
      borderColor: Colors.black54,
        borderRadius: BorderRadius.circular(5.0),
        children: [
        const Padding(
          padding: EdgeInsets.only(left: 25.0, right: 25.0),
          child: Text('変更する')
        ),
        Padding(
          padding: const EdgeInsets.only(left: 5.0, right: 5.0),
          child: createPopupMenuButton2()
        ),
      ]
    );
  }

  PopupMenuButton createPopupMenuButton2(){
    return PopupMenuButton(
      icon: const Icon(Icons.arrow_drop_down),
      offset: const Offset(50,50),
      itemBuilder: (BuildContext context) => <PopupMenuEntry>[
        const PopupMenuItem(
            child: ListTile(
                leading: Icon(Icons.add),
                title : Text('追加')
            )
        ),
        const PopupMenuItem(
          child: ListTile(
              leading: Icon(Icons.delete),
              title : Text('削除')
          ),
        ),
        const PopupMenuDivider(),
        const PopupMenuItem(
            child : ListTile(
                title : Text("その他")
            )
        )
      ],
    );
  }
}