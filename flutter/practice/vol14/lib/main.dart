import 'package:flutter/material.dart';
//import 'button/ButtonWidget.dart';
//import 'button/OutlineButtonWidget.dart';
import 'button/TextButtonWidget.dart';
//import 'button/ToggledButtonWidget.dart';
import 'menu/PopupMenuButtonWidget.dart';

void main() {
  //runApp(const MyApp());
  runApp(const TextButtonWidget());
  //runApp(const OutlineButtonWidget());
  //runApp(const TextButtonWidget());
  //runApp(const ToggledButtonWidget());
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
                fontSize: 20),
            bodyMedium: TextStyle(decoration: TextDecoration.none),
            labelLarge: TextStyle(fontSize: 15, letterSpacing: 2.0),
          ),
          useMaterial3: true,
        ),
        home: const PopupMenuButtonWidget());
  }
}
