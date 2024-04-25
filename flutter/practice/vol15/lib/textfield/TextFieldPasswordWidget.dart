import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class TextFieldPasswordWidget extends StatefulWidget{
  const TextFieldPasswordWidget({super.key});


  @override
  State<StatefulWidget> createState() {
    return _TextFieldPasswordWidget();
  }
}

class _TextFieldPasswordWidget extends State<TextFieldPasswordWidget>{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
            child : Padding(
                padding: const EdgeInsets.all(10.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    createField1(),
                  ],
                )
            )
        )
      )
    );
  }

  TextFormField createField1(){
    return TextFormField(
      maxLength: 20,
      obscureText: true,
      keyboardType: TextInputType.number,
      decoration: InputDecoration(
        suffixIcon: IconButton(
          icon: const Icon(Icons.visibility_off),
          onPressed: () {
            if (kDebugMode) {
              print("button push");
            }
          },
        )
      ),
    );
  }
}