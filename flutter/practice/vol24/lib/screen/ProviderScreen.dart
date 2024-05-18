import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:vol24/data/DateItem.dart';
import 'package:vol24/screen/parts/DateBlock.dart';
import 'package:http/http.dart' as http;

class WeekModel with ChangeNotifier {
  bool _loading = false;
  List<DateItem> _items = [];

  List<DateItem> get items => _items;
  bool get loading => _loading;

  void load() async{
    _loading = true;

    Future.delayed(Duration.zero,(){
      notifyListeners();
    });

    var res = await http.get(Uri.parse("http://192.168.1.1/list.json"),headers: {
      'Accept' : 'application/json'
    });
    var json = jsonDecode(utf8.decode(res.bodyBytes));
    _items = json['items'].map<DateItem>((e) => DateItem.fromJson(e)).toList();
    _loading = false;

    notifyListeners();
  }
}

class ProviderScreen extends StatelessWidget{
  const ProviderScreen({super.key});
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (_) => WeekModel(),
        child: Scaffold(
          appBar: AppBar(
              title: const Text('サンプル(2)'),
              actions: [
                Builder(
                    builder: (context){
                      final week = Provider.of<WeekModel>(context, listen: true);
                      return IconButton(
                          onPressed: week.loading ? null : (){
                            week.load();
                          },
                          icon: const Icon(Icons.refresh));
                    })
            ],
          ),
          body: const DateListScreen(),
        ),
    );
  }
}

class _DateListScreen extends State<DateListScreen>{

  @override
  void initState() {
    super.initState();
    final week = Provider.of<WeekModel>(context, listen: false);
    week.load();
  }

  @override
  Widget build(BuildContext context) {

    return Consumer<WeekModel>(
        builder: (context,week,child) {
          return Stack(
            children: [
              Column(
                children: _createListChildren(context, week),
              ),
              if(week.loading)
                _loadingWidget(context)
            ],
          );
        }
    );
  }

  // Loading 画面を表示
  Widget _loadingWidget(BuildContext context){
    return Container(
      width: MediaQuery.of(context).size.width,
      height: MediaQuery.of(context).size.height,
      color: Colors.grey.withOpacity(0.5),
      child: const Center(
        child: CircularProgressIndicator(),
      ),
    );
  }

  List<Widget> _createListChildren(BuildContext context,WeekModel model){
    var list = <Widget>[];

    for(var i = 0; i < model.items.length; i++){
      DateItem item = model.items[i];
      list.add(DateBlock(item: item));
    }
    return list;
  }
}

class DateListScreen extends StatefulWidget{

  const DateListScreen({super.key});

  @override
  State<StatefulWidget> createState() {
    return _DateListScreen();
  }
}