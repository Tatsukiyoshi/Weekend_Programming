import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class TextButtonWidget extends StatelessWidget{
  const TextButtonWidget({super.key});

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        body: Container(
          color: Colors.white,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextButton(
                  onPressed: (){
                    if (kDebugMode) {
                      print("button press !!");
                    }
                  },
                  child: const Text('OK')
              ),
              const TextButton(
                onPressed: null,
                child: Text('Disabled Button'),
              ),
              TextButton(
                  style: TextButton.styleFrom(
                    foregroundColor: Colors.red,
                  ),
                  onPressed: (){},
                  child: const Text('登録する'),
              ),
              TextButton.icon(
                icon: const Icon(Icons.add),
                onPressed: (){},
                label: const Text('登録する')
              )
            ],
          ),
        )
      )
    );
  }
}
