import 'package:flutter/material.dart';

class SimpleDialogWidget extends StatefulWidget {
  const SimpleDialogWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _SimpleDialogWidget();
  }
}

class _SimpleDialogWidget extends State<SimpleDialogWidget> {

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              OutlinedButton(
                  onPressed: (){ _openAlertDialog1(context); },
                  child: const Text("SimpleDialog(1)")
              ),
              OutlinedButton(
                  onPressed: (){ _openAlertDialog2(context); },
                  child: const Text("SimpleDialog(2)")
              ),
            ])
    );
  }

  Future<void> _openAlertDialog1(BuildContext context) async {
    showDialog(
        context: context,
        builder: (context) => SimpleDialog(
          title: const Text("よく利用する言語を選択してください"),
          children: [
            SimpleDialogOption(
              child: const ListTile(
                title: Text("Flutter"),
                leading: Icon(Icons.circle),
              ),
              onPressed: (){
                Navigator.pop(context,"flutter");
              },
            ),
            SimpleDialogOption(
              child: const ListTile(
                title: Text("Swift"),
                leading: Icon(Icons.circle),
              ),
              onPressed: (){
                Navigator.pop(context,"swift");
              },
            ),
            SimpleDialogOption(
              child: const ListTile(
                title: Text("Java"),
                leading: Icon(Icons.circle),
              ),
              onPressed: (){
                Navigator.pop(context,"java");
              },
            )
          ],
        )
    );
  }

  Future<void> _openAlertDialog2(BuildContext context) async {
    showDialog(
        context: context,
        barrierDismissible: false,
        builder: (context) => Dialog(
          child : Column(
            children: [
              const ListTile(
                title: Text("タイトル"),
              ),
              TextButton(
                  onPressed: (){
                    Navigator.pop(context);
                  },
                  child: const Text("閉じる"))
            ],
          ) 
        )
    );
  }
}