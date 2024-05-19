import 'package:flutter/material.dart';
//import 'package:sample1/pages/app_bar_sample.dart';
//import 'package:sample1/pages/floating_action_button_sample.dart';
import 'package:vol8/pages/scaffold_bottom_sheet.dart';
//import 'package:sample1/pages/scaffold_drawer.dart';
//import 'package:sample1/pages/scaffold_end_drawer.dart';
//import 'package:sample1/pages/scaffold_sample.dart';
//import 'package:sample1/pages/scaffold_snack_bar.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      // debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const ScaffoldBottomSheet()
    );
  }
}
