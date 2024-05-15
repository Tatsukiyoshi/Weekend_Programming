import 'package:flutter/material.dart';

class RadioWidget extends StatefulWidget {
  const RadioWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _RadioWidget();
  }
}

enum GroupValue {
  A , B
}
class _RadioWidget extends State<RadioWidget> {

  int _selectedValue = 1;
  GroupValue? _otherValue;

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
                leading: createRadio(1),
              ),
              ListTile(
                title : const Text('Value 2'),
                leading: createRadio(2),
              ),
              Text("Group 1 value is $_selectedValue"),

              Divider(),

              ListTile(
                title: const Text('Value A'),
                trailing: createOtherGroup(GroupValue.A),
              ),
              ListTile(
                title : const Text('Value B'),
                trailing: createOtherGroup(GroupValue.B),
              ),
              Text("Group 2 value(index) is ${_otherValue?.index}"),
              Text("Group 2 value is $_otherValue"),
              ListTile(
                title : const Text('Value C'),
                trailing: createDisableRadio(),
              ),
            ])
    );
  }

  Radio createRadio(int dataValue){
    return Radio(
      groupValue: _selectedValue,
      onChanged: (value) {
        setState(() {
          _selectedValue = value;
        });
      },
      value: dataValue,
    );
  }

  Radio createOtherGroup(GroupValue dataValue){
    return Radio<GroupValue>(
      groupValue: _otherValue,
      onChanged: (GroupValue? value) {
        //print("onChanged ${value?.index}");
        setState(() {
          _otherValue = value;
        });
      },
      value: dataValue,
    );
  }

  Radio createDisableRadio(){
    return const Radio(
      onChanged: null,

      value: false,
      groupValue: false,
    );
  }
}