import 'package:flutter/material.dart';
//import 'package:flutter/services.dart';

class DatePickerWidget extends StatefulWidget {
  const DatePickerWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _DatePickerWidget();
  }
}

class _DatePickerWidget extends State<DatePickerWidget> {

  DateTime _inputDate1 = DateTime.now();
  DateTime _inputDate2 = DateTime.now();
  //DateTime _inputDate3 = DateTime.now();

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              OutlinedButton(
                  onPressed: () => _openSample1(context),
                  child: const Text("日付選択(Calendar)")
              ),
              Text(_inputDate1.toString()),
              OutlinedButton(
                  onPressed: () => _openSample2(context),
                  child: const Text("日付選択(Input)")
              ),
              Text(_inputDate2.toString()),
              const Divider(),
              OutlinedButton(
                  onPressed: () => _openSample4(context),
                  child: const Text("日付(レンジ)選択")
              ),
              Text(_startDate.toString()),
              Text(_endDate.toString())
            ])
    );
  }

  Future<void> _openSample1(BuildContext context) async {
    final DateTime? date = await showDatePicker(
        context: context,
        initialDate:  _inputDate1,
        firstDate: DateTime(2024,1,1),
        lastDate: DateTime(2024,12,31),
    );
    if(date != null){
      setState(() {
        _inputDate1 = date;
      });
    }
  }

  Future<void> _openSample2(BuildContext context) async {
    final DateTime? date = await showDatePicker(
        context: context,
        initialDate: _inputDate2,
        firstDate: DateTime(2024,1,1),
        lastDate: DateTime(2024,12,31),
        //  入力モードを指定する
        initialEntryMode: DatePickerEntryMode.inputOnly,
        //locale: Locale('ja')
    );
    if(date != null){
      setState(() {
        _inputDate2 = date;
      });
    }
  }

  /*
  Future<void> _openSample3(BuildContext context) async {
    final DateTime? date = await showDatePicker(
        context: context,
        initialDate: DateTime.now(),
        firstDate: DateTime(2024,1,1),
        lastDate: DateTime(2024,12,31),
        currentDate: _inputDate3,
        locale: const Locale('ja')
    );
    if(date != null){
      setState(() {
        _inputDate3 = date;
      });
    }
  }
   */

  DateTime _startDate = DateTime.now();
  DateTime _endDate = DateTime.now();

  //  日付（レンジ）選択
  Future<void> _openSample4(BuildContext context) async {
    final DateTimeRange? range = await showDateRangePicker(
        context: context,
        initialDateRange: DateTimeRange(start: _startDate, end: _endDate),
        firstDate: DateTime(2024,1,1),
        lastDate: DateTime(2024,12,31),
    );
    if(range != null){
      setState(() {
        _startDate = range.start;
        _endDate = range.end;
      });
    }
  }
}