import 'package:flutter/material.dart';

class FilterChipWidget extends StatefulWidget {
  const FilterChipWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _FilterChipWidget();
  }
}

class _FilterChipWidget extends State<FilterChipWidget> {
  List values = [false, false, false];

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      alignment: Alignment.center,
      child: Wrap(
        spacing: 5.0,
        runSpacing: 5.0,
        children: [
          createFilterChip(context, 'Java', 0),
          createFilterChip(context, 'Swift', 1),
          createFilterChip(context, 'Flutter', 2),
        ])
    );
  }

  FilterChip createFilterChip(BuildContext context, String label, int index) {
    return FilterChip(
      label: Text(label),
      selected: values[index],
      onSelected: (value) {
        setState(() {
          values[index] = value;
        });
      },
      selectedColor: Colors.indigoAccent,
      labelStyle:
      TextStyle(color: values[index] ? Colors.white : Colors.black),
    );
  }
}
