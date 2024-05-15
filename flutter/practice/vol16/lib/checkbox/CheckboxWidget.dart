//import 'dart:ffi';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class CheckboxWidget extends StatefulWidget {
  const CheckboxWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _CheckboxWidget();
  }
}

class _CheckboxWidget extends State<CheckboxWidget> {

  List _checkedValues = [];
  List _childValues = [];

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
                leading: createCheck(1),
              ),
              ListTile(
                title : const Text('Value 2'),
                leading: createCheck(2),
              ),
              Text("Group 1 value is ${_checkedValues.toString()}"),

              const Divider(),

              ListTile(
                title: const Text('Group C'),
                leading: createOtherCheckbox(),
              ),
              Padding(
                padding: const EdgeInsets.only(left : 20),
                child: Column(
                  children: [
                    ListTile(
                      title : const Text('Child C-1'),
                      leading: createChildCheckbox(1),
                    ),
                    ListTile(
                      title : const Text('Child C-2'),
                      leading: createChildCheckbox(2),
                    ),
                  ],
                ),
              ),

              Text("Group 2 value(index) is ${_childValues.toString()}"),

              const Divider(),
              ListTile(
                title : const Text('変更出来ません'),
                leading: createDisableCheckbox(true),
              )
            ])
    );
  }

  Checkbox createCheck(int dataValue){
    return Checkbox(
      value: _checkedValues.contains(dataValue),
      onChanged: (bool? value) {
        if (kDebugMode) {
          print("on changed :${value?.toString()} - $dataValue");
        }
        setState(() {
          if(value != null && value){
            if(!_checkedValues.contains(dataValue)){
              _checkedValues.add(dataValue);
            }
          }
          else{
            if(_checkedValues.contains(dataValue)){
              _checkedValues.remove(dataValue);
            }
          }
        });
      },
    );
  }

  Checkbox createOtherCheckbox(){
    return Checkbox(
        value: _childValues.length == 2 ? true : (_childValues.isEmpty)? false : null,
        onChanged: (bool? value){
          setState(() {
            if (kDebugMode) {
              print("on change : $value");
            }
            if(value != null){
              if(value){
                _childValues = [1,2];
              }
              else{
                _childValues = [];
              }
            }
            else{
              _childValues = [];
            }
          });
        },
      //  true => null => false にする
      tristate: true,
    );
  }

  Checkbox createChildCheckbox(int dataValue){
    return Checkbox(
      value : _childValues.contains(dataValue),
      onChanged: (bool? value){
        setState(() {
          if(value != null && value){
            if(!_childValues.contains(dataValue)) {
              _childValues.add(dataValue);
            }
          }
          else{
            if(_childValues.contains(dataValue)) {
              _childValues.remove(dataValue);
            }
          }
        });
      },
    );
  }

  Checkbox createDisableCheckbox(bool checked){
    return Checkbox(
      value: checked,

      onChanged: null,
    );
  }
}