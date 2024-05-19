import 'package:flutter/material.dart';
//import 'package:vol11/AlignWidget.dart';
//import 'package:vol11/AspectRatioWidget.dart';
//import 'package:vol11/CenterWidget.dart';
//import 'package:vol11/ColumnWidget.dart';
//import 'package:vol11/ContainerWidget.dart';
//import 'package:vol11/PaddingWidget.dart';
//import 'package:vol11/RowWidget.dart';
import 'package:vol11/WrapWidget.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Layouts',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Layouts'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      /*
      appBar: AppBar(
        title: Text(widget.title),
      ),

      */
      body: Center(
        child : Container(
        alignment: Alignment.center,
          width: double.infinity,
          height: double.infinity,
          color: Colors.grey,
          // child: const ContainerWidget(),
          // child: const PaddingWidget(),
          // child: const RowWidget(),
          child: const WrapWidget(),
        )
      ),
    );
  }
}
