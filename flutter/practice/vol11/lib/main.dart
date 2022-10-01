import 'package:flutter/material.dart';
import 'package:flutter_layouts/AlignWidget.dart';
import 'package:flutter_layouts/AspectRatioWidget.dart';
import 'package:flutter_layouts/CenterWidget.dart';
import 'package:flutter_layouts/ColumnWidget.dart';
import 'package:flutter_layouts/ContainerWidget.dart';
import 'package:flutter_layouts/PaddingWidget.dart';
import 'package:flutter_layouts/RowWidget.dart';
import 'package:flutter_layouts/WrapWidget.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Layouts',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter Layouts'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

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
          child: WrapWidget(),
        )
      ),
    );
  }
}
