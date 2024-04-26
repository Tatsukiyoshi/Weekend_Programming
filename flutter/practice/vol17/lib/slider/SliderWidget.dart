import 'package:flutter/material.dart';
//import 'package:flutter/services.dart';

class SliderWidget extends StatefulWidget {
  const SliderWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _SliderWidget();
  }
}

class _SliderWidget extends State<SliderWidget> {

  double _value1 = 10;
  double _value2 = 10;

  RangeValues _value3 = const RangeValues(10,20);

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              createSample1(context),
              Text('value1 : $_value1'),
              const Divider(),
              createSample2(context),
              Text('value2 : $_value2'),

              const Divider(),
              createSample3(context),
              Text('value3 : ${_value3.start} - ${_value3.end}'),
            ])
    );
  }

  Slider createSample1(BuildContext context){
    return Slider(
      value : _value1,
      min : 0,
      max : 100,
      label: _value1.round().toString(),
      onChanged: (value){
        setState(() {
          _value1 = value.round().toDouble();
        });
      },
    );
  }

  Slider createSample2(BuildContext context){
    return Slider(
      value : _value2,
      min : 0,
      max : 100,
      label: "${_value2.round()}",
      divisions: 20,
      inactiveColor: Colors.black12,
      activeColor: Colors.red,
      onChanged: (value){
        setState(() {
          _value2 = value.round().toDouble();
        });
      },
    );
  }

  RangeSlider createSample3(BuildContext context){
    return RangeSlider(
      values : _value3,
      min : 0,
      max : 100,
      labels: RangeLabels(
        _value3.start.round().toString(),
        _value3.end.round().toString()
      ),
      divisions: 20,
      onChanged: (value){
        setState(() {
          _value3 = RangeValues(
              value.start.round().toDouble(),
              value.end.round().toDouble());
        });
      },
    );
  }
}