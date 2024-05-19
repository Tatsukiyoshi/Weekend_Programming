import 'package:flutter/material.dart';
// import 'package:vol13/icon/IconWidget.dart';
// import 'package:vol13/text/Text0Widget.dart';
// import 'package:vol13/text/Text1Widget.dart';
// import 'package:vol13/text/Text2Widget.dart';
import 'package:vol13/text/Text3Widget.dart';
// import 'package:vol13/text/Text4Widget.dart';

void main() {
  runApp(const MyApp());
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
      ),
      // home: IconWidget()
      // home: Text0Widget()
      // home: Text1Widget()
      // home: Text2Widget()
     home: const Text3Widget()
      // home: const Text4Widget()
    );
  }
}
