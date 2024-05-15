import 'package:flutter/material.dart';

class ChoiceChipWidget extends StatefulWidget {
  const ChoiceChipWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _ChoiceChipWidget();
  }
}

class _ChoiceChipWidget extends State<ChoiceChipWidget> {
  List values = [false, false, false];

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      alignment: Alignment.center,
      child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [
        Wrap(
          spacing: 5.0,
          runSpacing: 5.0,
          children: [
            createSelectedTagChip(context, 'Java', 0),
            createSelectedTagChip(context, 'Swift', 1),
            createSelectedTagChip(context, 'Flutter', 2),
          ],
        )
      ]));
  }

  ChoiceChip createSelectedTagChip(BuildContext context,String label,int index){
    return ChoiceChip(
      avatar: values[index]
          ? const Icon(Icons.check_box_outlined)
          : const Icon(Icons.check_box_outline_blank),
      label: Text(label),
      selected: values[index],
      onSelected: (value) {
        setState(() {
          values[index] = value;
        });
      },
      selectedColor: Colors.blueAccent,
      labelStyle:
      TextStyle(color: values[index] ? Colors.white : Colors.black),
    );
  }
}
