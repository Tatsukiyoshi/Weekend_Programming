import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class SwitchWidget extends StatefulWidget {
  const SwitchWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _SwitchWidget();
  }
}

class _SwitchWidget extends State<SwitchWidget> {

  List _switchValues = [false,false];

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ListTile(
                title : const Text('Value 1'),
                trailing: createSwitch(0),
              ),
              ListTile(
                title : const Text('Value 2'),
                trailing: createSwitch(1),
              ),
              Text("Switch values: ${_switchValues.toString()}"),

              const Divider(),

              ListTile(
                title: const Text('Value C'),
                leading: createDisableSwitch(true),
              ),
              ListTile(
                title: const Text('Value D'),
                leading: createDisableSwitch(false),
              ),
            ])
    );
  }

  Switch createSwitch(int index){
    return Switch(
      value: _switchValues[index],
      onChanged: (bool? value) {
        if (kDebugMode) {
          print("on changed :${value?.toString()} - $value");
        }
        setState(() {
          _switchValues[index] = value;
        });
      },
    );
  }

  Switch createDisableSwitch(bool checked){
    return Switch(
      value: checked,
      onChanged: null,
    );
  }
}