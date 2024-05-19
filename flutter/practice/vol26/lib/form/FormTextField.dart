import 'package:flutter/material.dart';
import 'package:vol26/form/FormFieldKey.dart';
import 'package:vol26/form/FormWidget.dart';

class _FormTextField extends State<FormTextField>{

  bool watch = false;

  late TextEditingController _textEditingController;

  @override
  void initState() {
    super.initState();

    _textEditingController = TextEditingController();

    if(widget.key is FormFieldKey){
      FormFieldKey key = widget.key as FormFieldKey;
      String? value = FormWidget.of(context)?.value(key.value);

      if(value != null){
        _textEditingController.text = value;
      }

      _textEditingController.addListener(() {
        FormWidget.of(context)?.set(key.value,_textEditingController.text);
      });
    }
  }


  @override
  void dispose() {
    _textEditingController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {

    return Container(
      margin: const EdgeInsets.only(bottom: 15),
        child : TextField(
          controller: _textEditingController,
      decoration: InputDecoration(
        border: const OutlineInputBorder(),
        labelText: widget.label,
      )
    ));
  }
}


class FormTextField extends StatefulWidget{

  final String label;

  const FormTextField({
    super.key,
    required this.label
  });

  @override
  State createState() {
    return _FormTextField();
  }
}