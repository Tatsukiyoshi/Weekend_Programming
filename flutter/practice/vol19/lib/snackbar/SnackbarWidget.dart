import 'package:flutter/material.dart';

class SnackbarWidget extends StatefulWidget {
  const SnackbarWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _SnackbarWidget();
  }
}

class _SnackbarWidget extends State<SnackbarWidget> {
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: SizedBox(
        width: double.infinity,
        child:
          Column(
          mainAxisAlignment: MainAxisAlignment.center,
          // crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            OutlinedButton(
                child: const Text("Create SnackBar(1)"),
                onPressed: (){
                  ScaffoldMessenger.of(context).showSnackBar(createSnackBar1(context));
                }
            ),
            OutlinedButton(
                child: const Text("Create SnackBar(2)"),
                onPressed: (){
                  ScaffoldMessenger.of(context).showSnackBar(createSnackBar2(context));
                }
            )
          ]
      )),
    );
  }

  SnackBar createSnackBar1(BuildContext context){
    return SnackBar(
      content: const Text("削除しました"),
      action: SnackBarAction(
        label: "取消",
        onPressed: (){

        },
      ),
    );
  }

  SnackBar createSnackBar2(BuildContext context){
    return SnackBar(
      content: const Text("削除しました"),
      behavior: SnackBarBehavior.floating,
      duration: const Duration(milliseconds: 2000),
      backgroundColor: Colors.red,
      dismissDirection: DismissDirection.up,
      action: SnackBarAction(
        textColor: Colors.white,
        label: "取消",
        onPressed: (){

        },
      ),
    );
  }
}