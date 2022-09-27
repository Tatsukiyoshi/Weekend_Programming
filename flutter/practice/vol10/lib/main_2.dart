import 'package:flutter/material.dart';
import 'package:vol10/ItemRouterDelegate.dart';
import 'package:vol10/ItemRouterInformationParser.dart';

void main() {
  runApp(MainApp2());
}
class MainApp2 extends StatefulWidget{

  @override
  State<StatefulWidget> createState() {
    return _MainApp2();
  }
}

class _MainApp2 extends State<MainApp2>{

  ItemRouterDelegate _routerDelegate = ItemRouterDelegate();
  ItemRouterInformationParser _routerInformationParser = ItemRouterInformationParser();

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
        title: "Nav2 App",
        debugShowCheckedModeBanner : false,
        routeInformationParser: _routerInformationParser,
        routerDelegate: _routerDelegate,
    );
  }
}