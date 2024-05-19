import 'package:flutter/cupertino.dart';

class FormData{

  final Map<String,String> _data = {};

  FormData();

  String? value(String name){
    if(_data.containsKey(name)){
      return _data[name];
    }
    return '';
  }

  void set(String name,String value){
    _data[name] = value;
  }

  @override
  String toString() {
    return 'FormData{_data: $_data}';
  }
}


class FormWidget extends StatelessWidget{

  final Widget child;
  final FormData data;

  const FormWidget({
    required this.child,
    required this.data,
    super.key});

  @override
  Widget build(BuildContext context) => child;

  static FormData? of(BuildContext context) {
    final FormWidget? widget = context.findAncestorWidgetOfExactType<FormWidget>();
    return widget?.data;
  }
}
