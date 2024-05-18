import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:http/http.dart' as http;
import 'package:vol24/data/DateItem.dart';
import 'package:vol24/screen/parts/DateBlock.dart';

class DateModel {
  final List<DateItem> items;
  final bool loading;
  DateModel(this.items, this.loading);
}

class WeekBloc{
  final _controller = StreamController<DateModel>();
  Stream<DateModel> get stream => _controller.stream;

  List<DateItem> _last = [];

  void load() async{
    _controller.sink.add(DateModel(_last, true));
    var res = await http.get(Uri.parse("http://192.168.1.1/list.json"),headers: {
      'Accept' : 'application/json'
    });
    var json = jsonDecode(utf8.decode(res.bodyBytes));
    var week = json['items'].map<DateItem>((e) => DateItem.fromJson(e)).toList();
    _last = week;
    _controller.sink.add(DateModel(week, false));
  }
  void dispose(){
    _controller.close();
  }
}

class StreamScreen extends StatelessWidget {
  const StreamScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Provider<WeekBloc>(
        create: (context) => WeekBloc(),
        dispose: (_,bloc) => bloc.dispose(),
        child: const DateListScreen(),
    );
  }
}

class _DateListScreen extends State<DateListScreen>{

  @override
  void initState() {
    super.initState();
    final bloc = Provider.of<WeekBloc>(context, listen: false);
    bloc.load();
  }

  @override
  Widget build(BuildContext context) {

    final bloc = Provider.of<WeekBloc>(context);

    return StreamBuilder<DateModel>(
      stream: bloc.stream,
      initialData: null,
      builder: (context, snapshot) {
        final DateModel? block = snapshot.data;

        return Scaffold(
          appBar: AppBar(
            title: const Text('サンプル(3)'),
            actions: [
              IconButton(
                  onPressed: (block == null || block.loading)? null : (){
                    bloc.load();
                  },
                  icon: const Icon(Icons.refresh),
              )
            ],
          ),
          body: Stack(
            children: [
              if(block != null)
                Column(
                  children: _createListChildren(context, block),
                ),
              if(block == null || block.loading)
                _loadingWidget(context)
            ],
          )
        );
      },
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

  List<Widget> _createListChildren(BuildContext context,DateModel model){
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