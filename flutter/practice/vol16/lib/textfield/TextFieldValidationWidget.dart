import 'package:flutter/material.dart';

class TextFieldValidationWidget extends StatefulWidget {
  const TextFieldValidationWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TextFieldValidationWidget();
  }
}

class _TextFieldValidationWidget extends State<TextFieldValidationWidget> {
  final _formState = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Form(
        key: _formState,
        child: Padding(
            padding: const EdgeInsets.all(10.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextFormField(validator: (value) {
                  if (value == null || value.isEmpty) {
                    return "入力してください";
                  }
                  return null;
                }),
                ElevatedButton(
                    onPressed: () {
                      _formState.currentState!.validate();
                    },
                    child: const Text("値をチェックする")),
                const Divider(),
              ],
            )));
  }
}