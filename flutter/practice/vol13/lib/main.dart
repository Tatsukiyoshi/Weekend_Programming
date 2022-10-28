import 'package:flutter/material.dart';
// import 'package:ui_samples/icon/IconWidget.dart';
// import 'package:ui_samples/text/Text0Widget.dart';
// import 'package:ui_samples/text/Text1Widget.dart';
// import 'package:ui_samples/text/Text2Widget.dart';
// import 'package:ui_samples/text/Text3Widget.dart';
import 'package:ui_samples/text/Text4Widget.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        textTheme: TextTheme(
          bodyText1: TextStyle(
              color: Colors.black54,
              fontWeight: FontWeight.normal,
              fontStyle: FontStyle.normal,
              decoration: TextDecoration.none,
              fontSize: 20
          ),
          bodyText2: TextStyle(
              decoration: TextDecoration.none
          ),
          button: TextStyle(
            fontSize: 15,
                letterSpacing: 2.0
          ),
        ),
      ),
      // home: IconWidget()
      // home: Text0Widget()
      // home: Text1Widget()
      // home: Text2Widget()
      // home: Text3Widget()
      home: Text4Widget()
    );
  }
}
