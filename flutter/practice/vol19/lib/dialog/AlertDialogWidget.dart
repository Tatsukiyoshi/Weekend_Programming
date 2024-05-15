//import 'dart:ffi';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class AlertDialogWidget extends StatefulWidget {
  const AlertDialogWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _AlertDialogWidget();
  }
}

class _AlertDialogWidget extends State<AlertDialogWidget> {

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              OutlinedButton(
                  onPressed: (){
                    _openAlertDialog1(context);
                  },
                  child: const Text("AlertDialog(1)")
              ),
              OutlinedButton(
                  onPressed: (){
                    _openAlertDialog2(context);
                  },
                  child: const Text("AlertDialog(2)")
              ),
            ])
    );
  }

  Future<void> _openAlertDialog1(BuildContext context) async {
    var ret = await showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text("入力確認"),
          content: const Text("よろしいですか"),
          actions: [
            TextButton(onPressed: () => {
              //  ダイアログを閉じる
              Navigator.pop(context,false)
            },
                child: const Text("いいえ")
            ),
            TextButton(onPressed: (){
              Navigator.pop(context,true);
              },
              child: const Text("はい")
            ),
          ],
        )
    );

    if(ret != null) {
      if (ret == true) {
        if (kDebugMode) {
          print("---- YES -----");
        }
      }
      else {
        if (kDebugMode) {
          print("---- NO -----");
        }
      }
    }
    else{
      //  選択せずに閉じた場合
      if (kDebugMode) {
        print("---- NULL ----");
      }
    }
  }

  Future<void> _openAlertDialog2(BuildContext context) async {
    var ret = await showDialog(
        context: context,
        //  範囲外をタップしても閉じないようにする
        barrierDismissible: false,
        builder: (context) => AlertDialog(
          title: const Text("入力確認"),
          content: const Text("よろしいですか"),
          actions: [
            TextButton(onPressed:(){
              //  ダイアログを閉じる
              Navigator.pop(context,false);
            },
                child: const Text("いいえ")
            ),
            TextButton(onPressed: (){
                Navigator.pop(context,true);
              },
              child: const Text("はい")
            ),
          ],
        )
    );
    //
    if (ret == true) {
      if (kDebugMode) {
        print("---- YES -----");
      }
    }
    else {
      if (kDebugMode) {
        print("---- NO -----");
      }
    }
  }
}
