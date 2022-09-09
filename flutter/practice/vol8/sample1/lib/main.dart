import 'package:flutter/material.dart';
import 'package:sample1/pages/AppBarSample.dart';
import 'package:sample1/pages/FloatingActionButtonSample.dart';
import 'package:sample1/pages/ScaffoldBottomSheet.dart';
import 'package:sample1/pages/ScaffoldDrawer.dart';
import 'package:sample1/pages/ScaffoldEndDrawer.dart';
import 'package:sample1/pages/ScaffoldSample.dart';
import 'package:sample1/pages/ScaffoldSnackBar.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: ScaffoldBottomSheet()
    );
  }
}
