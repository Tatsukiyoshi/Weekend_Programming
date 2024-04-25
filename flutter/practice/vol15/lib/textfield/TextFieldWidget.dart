import 'package:flutter/material.dart';

class TextFieldWidget extends StatefulWidget {
  const TextFieldWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TextFieldWidget();
  }
}

class _TextFieldWidget extends State<TextFieldWidget> {
  @override
  Widget build(BuildContext context) {
    return Center(
        child: Padding(
            padding: const EdgeInsets.all(10.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                createField1(),
                createField2(),
                Divider(),
                createField3(),
                //createField4()
              ],
            )));
  }

  TextFormField createField1() {
    return TextFormField(
        maxLength: 20,
        initialValue: "ABCDE1234",
        decoration: const InputDecoration(
          icon: Icon(Icons.email),
          suffixIcon: Icon(Icons.check_circle),
          labelText: 'ログインID',
          hintText: "ログインIDを入力してください",
          errorText: "入力必須です",
          helperText: "ログインIDは郵送でお知らせしているIDです",
          filled: true,
        ));
  }

  TextFormField createField2() {
    return TextFormField(
        maxLength: 20,
        obscureText: true,
        decoration: const InputDecoration(
            prefixIcon: Icon(Icons.vpn_key),
            suffixIcon: Icon(Icons.visibility_off),
            labelText: "パスワード",
            hintText: "入力必須です",
            helperText: "初期パスワードははがきに記されています",
            enabledBorder: UnderlineInputBorder(
                borderSide: BorderSide(color: Colors.grey)),
            focusedBorder: UnderlineInputBorder(
                borderSide: BorderSide(width: 5, color: Colors.deepPurple))));
  }

  TextFormField createField3() {
    return TextFormField(
        maxLength: 20,
        keyboardType: TextInputType.number,
        decoration: const InputDecoration(
          border: OutlineInputBorder(),
          suffixText: "円",
          labelText: '金額',
          hintText: '3000円以上を設定して下さい',
        ));
  }

  TextFormField createField4() {
    return TextFormField(
        maxLines: 4,
        decoration: const InputDecoration(
            border: OutlineInputBorder(),
            labelText: 'メモ',
            helperText: "ご自由にご記入ください",
            focusColor: Colors.blueGrey));
  }
}
