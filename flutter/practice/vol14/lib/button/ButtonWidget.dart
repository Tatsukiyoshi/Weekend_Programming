import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class ButtonWidget extends StatelessWidget{
  const ButtonWidget({super.key});

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        body: Container(
            color: Colors.white,

            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                    onPressed: (){
                      if (kDebugMode) {
                        print("button press !!");
                      }
                    },
                    child: const Text('OK')
                ),
                const ElevatedButton(
                  onPressed: null,
                  child: Text('Disabled Button'),
                ),
                ElevatedButton(
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.red,
                        elevation: 10,
                        //  角を丸くする
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30.0),
                        )
                    ),
                    onPressed: (){},
                    child: const Text('登録する')
                ),
                ElevatedButton.icon(
                    onPressed: (){},
                    icon: const Icon(Icons.add),
                    label: const Text('追加する')
                ),
              ],
            ),
          )
      )
    );
  }
}