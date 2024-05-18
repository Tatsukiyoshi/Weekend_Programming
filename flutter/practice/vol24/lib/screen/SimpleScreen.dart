import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:vol24/data/DateItem.dart';
import 'package:vol24/screen/parts/DateBlock.dart';

class _SimpleScreen extends State<SimpleScreen>{

  bool _loading = true;
  List<DateItem> _week = [];

  @override
  void initState() {
    super.initState();
    _loadData();
  }

  void _loadData() async{
    var res = await http.get(Uri.parse("http://192.168.1.1/list.json"),headers: {
      'Accept' : 'application/json'
    });

    setState(() {
      var json = jsonDecode(utf8.decode(res.bodyBytes));
      _loading = false;
      _week = json['items'].map<DateItem>((e) => DateItem.fromJson(e)).toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          title: const Text('サンプル(1)'),
          actions: [
            IconButton(onPressed: _loading? null :(){
              setState(() {
                _loading = true;
              });
              _loadData();
            }, icon: const Icon(Icons.refresh))
          ],
      ),
      body: Stack(
        children: [
          Column(
            children : _createListChildren(context),
          ),
          if(_loading)
            loadingWidget(context)
        ]
      ),
    );
  }

  // Loading 画面を表示
  Widget loadingWidget(BuildContext context){
    return Container(
      width: MediaQuery.of(context).size.width,
      height: MediaQuery.of(context).size.height,
      color: Colors.grey.withOpacity(0.5),
      child: const Center(
        child: CircularProgressIndicator(),
      ),
    );
  }

  Widget listWidget(BuildContext context){
    return Center(
      child: Column(
        children : _createListChildren(context)
      ),
    );
  }

  List<Widget> _createListChildren(BuildContext context){
    var list = <Widget>[];
    for(var i = 0; i < _week.length; i++){
      DateItem item = _week[i];
      list.add(DateBlock(item: item));
    }
    return list;
  }
}

class SimpleScreen extends StatefulWidget{

  const SimpleScreen({super.key});

  @override
  State createState() {
    return _SimpleScreen();
  }
}