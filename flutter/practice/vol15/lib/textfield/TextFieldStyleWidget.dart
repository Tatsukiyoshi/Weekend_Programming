import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:intl/intl.dart';

class TextFieldStyleWidget extends StatefulWidget {
  const TextFieldStyleWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TextFieldStyleWidget();
  }
}

class _TextFieldStyleWidget extends State<TextFieldStyleWidget> {
  @override
  Widget build(BuildContext context) {
    return Center(
        child: Padding(
            padding: const EdgeInsets.all(10.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                createField1(),
              ],
            )));
  }

  TextFormField createField1() {
    return TextFormField(
      maxLength: 10,
        textAlign: TextAlign.right,
        style: const TextStyle(
          fontWeight: FontWeight.bold,
          letterSpacing: 10
        ),
        inputFormatters: [
          FilteringTextInputFormatter.digitsOnly,
          NumberInputFormatter()
        ],
        decoration: const InputDecoration(
          suffixText: "円",
          filled: true,
          labelText: "指定金額",
          labelStyle: TextStyle(
            fontSize: 20,
            letterSpacing: 5
          )
        )
    );
  }
}

class NumberInputFormatter extends TextInputFormatter {
  @override
  TextEditingValue formatEditUpdate(
      TextEditingValue oldValue, TextEditingValue newValue) {
    final text = newValue.text;

    final number = int.parse(text);
    final formatter = NumberFormat("#,###");
    final newText = formatter.format(number);
    return newValue.copyWith(
        text: newText,
        selection: TextSelection.collapsed(offset: newText.length));
  }
}
