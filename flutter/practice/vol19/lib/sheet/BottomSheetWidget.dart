import 'package:flutter/material.dart';

class BottomSheetWidget extends StatefulWidget {
  const BottomSheetWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _BottomSheetWidget();
  }
}

class _BottomSheetWidget extends State<BottomSheetWidget> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Container(
            color: Colors.white,
            alignment: Alignment.center,
            child:
                Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      OutlinedButton(
                        child: const Text("Bottom sheet"),
                        onPressed: (){
                          showBottomSheet(
                            context: context,
                            builder: (context) {
                              return createBottomSheet(context);
                            });
                        }
                        ),
                      OutlinedButton(
                          child: const Text("Bottom sheet (modal)"),
                          onPressed: (){
                            showModalBottomSheet(
                                context: context,
                                builder: (context) {
                                  return createBottomSheet(context);
                                });
                          }
                      )
                    ]
    )));
  }

  Widget createBottomSheet(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(top : 0, bottom : 48.0),
      child: Wrap(
        children: [
          const ListTile(
            title: Text("以下から選択してください"),
            tileColor: Colors.black,
            textColor: Colors.white,
          ),
          const ListTile(
            title: Text("選択肢(1)"),
          ),
          const ListTile(
            title: Text("選択肢(2)"),
          ),
          Container(
            margin: const EdgeInsets.all(5.0),
            width: double.infinity,
            child: OutlinedButton(
                onPressed: (){
                  Navigator.pop(context);
                },
                child: const Text("閉じる")),
          )
        ],
      ),
    );
  }
}
