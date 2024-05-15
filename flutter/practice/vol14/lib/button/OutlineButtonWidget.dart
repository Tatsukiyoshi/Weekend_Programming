import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class OutlineButtonWidget extends StatelessWidget{
  const OutlineButtonWidget({super.key});

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        body: Container(
            color: Colors.white,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                OutlinedButton(
                    onPressed: (){
                      if (kDebugMode) {
                        print("button press !!");
                      }
                    },
                    child: const Text('OK')
                ),
                const OutlinedButton(
                  onPressed: null,
                  child: Text('Disabled Button'),
                ),
                OutlinedButton(
                    style: OutlinedButton.styleFrom(
                        foregroundColor: Colors.red,
                        side: const BorderSide(
                          color: Colors.red,
                        )
                    ),
                    onPressed: (){},
                    child: const Text('登録する')
                ),
                OutlinedButton.icon(
                    onPressed: (){},
                    icon: const Icon(Icons.add),
                    label: const Text('登録する')
                )
              ],
            ),
          )
      )
    );
  }
}
