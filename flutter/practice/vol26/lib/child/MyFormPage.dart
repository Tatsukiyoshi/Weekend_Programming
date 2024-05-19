import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:vol26/form/FormFieldKey.dart';
import 'package:vol26/form/FormTextField.dart';
import 'package:vol26/form/FormWidget.dart';
import 'package:vol26/logger/LoggerWidget.dart';

final FormData formData = FormData();

class MyFormPage extends StatelessWidget{

  const MyFormPage({super.key});

  @override
  Widget build(BuildContext context) {
    return FormWidget(
      data: formData,
      child: Scaffold(
        appBar: AppBar(title: const Text('入力を保持するフォーム'),
            actions: [
              IconButton(
                  onPressed: (){
                    if (kDebugMode) {
                      print("pressed $formData");
                    }
                  },
                  icon: const Icon(Icons.send)
              )
            ]),
        body: Container(
          margin: const EdgeInsets.all(10),
          child: const Column(
            children: [
              FormTextField(
                  key: FormFieldKey("company_name"),
                  label: '会社名'),
              FormTextField(
                  key : FormFieldKey("email"),
                  label: 'ログインメールアドレス'),
              FormTextField(
                  label: 'パスワード'),
            ],
          ),
        )
      ),
    );
  }
}