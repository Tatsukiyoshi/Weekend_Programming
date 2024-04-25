import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class TextFieldValueWidget extends StatefulWidget {
  const TextFieldValueWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _TextFieldValueWidget();
  }
}

class _TextFieldValueWidget extends State<TextFieldValueWidget> {
  final TextEditingController _textController = TextEditingController();
  String _loginId = "";

  @override
  void dispose() {
    _textController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: Padding(
              padding: const EdgeInsets.all(10.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  TextFormField(
                    initialValue: "INIT VALUE",
                  ),
                  const Divider(),
                  TextFormField(
                    onChanged: (value) {
                      setState(() {
                        _loginId = value;
                      });
                    },
                  ),
                  const Divider(),
                  TextFormField(
                    controller: _textController,
                  ),
                  ElevatedButton(
                      onPressed: () {
                        setState(() {
                          _loginId = _textController.text;
                        });
                      },
                      child: const Text("Submit")),
                  const Divider(),
                  Text(_loginId),
                  ElevatedButton(
                      onPressed: () {
                        _textController.text = "ABCD1234";
                      },
                      child: const Text("Set Value")),
                ],
        )))
      )
    );
  }

  @override
  void initState() {
    super.initState();
    _textController.addListener(() {
      if (kDebugMode) {
        print("changed value [${_textController.text}]");
      }
    });
  }
}
