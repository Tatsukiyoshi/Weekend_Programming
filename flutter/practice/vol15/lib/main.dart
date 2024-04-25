import 'package:flutter/material.dart';
import 'textfield/TextFieldWidget.dart';
//import 'textfield/TextFieldPasswordWidget.dart';
//import 'textfield/TextFieldValueWidget.dart';

// No sample code is presented for the following:
//import 'package:ui_samples/textfield/TextFieldFocusWidget.dart';
//import 'package:ui_samples/textfield/TextFieldValidationWidget.dart';

void main() {
  runApp(const MyApp());
  //runApp(TextFieldPasswordWidget());
  //runApp(TextFieldValueWidget());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        textTheme: const TextTheme(
          bodyLarge: TextStyle(
              color: Colors.black54,
              fontWeight: FontWeight.normal,
              fontStyle: FontStyle.normal,
              decoration: TextDecoration.none,
              fontSize: 20
          ),
          bodyMedium: TextStyle(
              decoration: TextDecoration.none
          ),
          labelLarge: TextStyle(
            fontSize: 15,
                letterSpacing: 2.0
          ),
        ),
        inputDecorationTheme: const InputDecorationTheme(
          border: OutlineInputBorder(
            borderSide: BorderSide(
              color: Colors.black38
            )
          ),
          focusedBorder: OutlineInputBorder(
              borderSide: BorderSide(
                  color: Colors.black54
              )
          ),
        )
      ),
      home: const Scaffold(
        //body: TextFieldValidationWidget()
        body: TextFieldWidget()
      )
    );
  }
}