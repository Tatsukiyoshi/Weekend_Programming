import 'package:flutter/material.dart';

class InputChipWidget extends StatefulWidget {
  const InputChipWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _InputChipWidget();
  }
}

class _InputChipWidget extends State<InputChipWidget> {
  List values = [false, false, false];

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      alignment: Alignment.center,
      child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
        const Text("選択済み"),
        createSelectedTag(context),
        const Divider(),
        const Text("未選択"),
        createUnSelectedTag(context),
      ]));
  }

  Widget createSelectedTag(BuildContext context) {
    return Wrap(
      spacing: 5.0,
      runSpacing: 5.0,
      children: [
        if(values[0]) createTagChip(context, "Java", 0),
        if(values[1]) createTagChip(context, "Swift", 1),
        if(values[2]) createTagChip(context, "Flutter", 2)
      ]);
  }
  Widget createUnSelectedTag(BuildContext context) {
    return Wrap(
      spacing: 5.0,
      runSpacing: 5.0,
      children: [
        if(!values[0]) createNotSelectedChip(context, "Java", 0),
        if(!values[1]) createNotSelectedChip(context, "Swift", 1),
        if(!values[2]) createNotSelectedChip(context, "Flutter", 2)
      ]);
  }

  InputChip createTagChip(BuildContext context, String label, int index){
    return InputChip(
      label: Text(label),
      deleteIcon: const Icon(Icons.close),
      onDeleted : () {
        setState(() {
          values[index] = false;
        });
      });
  }

  InputChip createNotSelectedChip(BuildContext context, String label, int index){
    return InputChip(
      label: Text(label),
      onSelected: (value){
        setState(() {
          values[index] = value;
        });
      }
    );
  }
}
