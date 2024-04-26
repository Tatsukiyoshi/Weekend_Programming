import 'package:flutter/material.dart';

class TimePickerWidget extends StatefulWidget {
  const TimePickerWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TimePickerWidget();
  }
}

class _TimePickerWidget extends State<TimePickerWidget> {

  TimeOfDay _inputTime1 = TimeOfDay.now();
  TimeOfDay _inputTime2 = TimeOfDay.now();

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
                  child: const Text("時間選択（ダイヤル）")
              ),
              Text(_inputTime1.toString()),
              const Divider(),
              OutlinedButton(
                  onPressed: () => _openSample2(context),
                  child: const Text("時間選択（テキスト）")
              ),
              Text(_inputTime2.toString()),
              const Divider(),
            ])
    );
  }

  Future<void> _openSample1(BuildContext context) async {
    final TimeOfDay? date = await showTimePicker(
        context: context,
        initialTime: _inputTime1,
    );
    if(date != null){
      setState(() {
        _inputTime1 = date;
      });
    }
  }

  Future<void> _openSample2(BuildContext context) async {
    final TimeOfDay? date = await showTimePicker(
        context: context,
        initialTime: _inputTime2,
        //  入力モード
        initialEntryMode: TimePickerEntryMode.input,
        builder: (BuildContext context, Widget? child) {
          return MediaQuery(
            data: MediaQuery.of(context).copyWith(
                alwaysUse24HourFormat: true,
            ),
            child: child!,
        );
      },
    );
    if(date != null){
      setState(() {
        _inputTime2 = date;
      });
    }
  }
}