import 'package:flutter/material.dart';

class ToggledButtonWidget extends StatelessWidget{
  const ToggledButtonWidget({super.key});

  @override
  Widget build(BuildContext context) {

    final isSelected = <bool>[true, false, false];

    return MaterialApp(
      home: Scaffold(
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Center(
                child: createButton2()
            )
          ],
        ),
      )
   );
  }

  ToggleButtons createButton1(){

    final isSelected = <bool>[true, false, false];
    return ToggleButtons(
      isSelected: isSelected,
      onPressed: (index){},
      children: const [
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 1'),
        ),
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 2'),
        ),
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 3'),
        ),
      ],
    );
  }

  ToggleButtons createButton2(){

    final isSelected = <bool>[true, false, false];
    return ToggleButtons(
      isSelected: isSelected,
      onPressed: (index){},

      borderWidth: 2,
      borderColor: Colors.amber,
      //  角マルにする
      borderRadius: BorderRadius.circular(5.0),
      selectedColor: Colors.white,
      selectedBorderColor: Colors.black54,
      //  選択済みに背景色
      fillColor: Colors.red,

      children: const [
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 1'),
        ),
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 2'),
        ),
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 3'),
        ),
      ],
    );
  }

  ToggleButtons createButton3(){

    final isSelected = <bool>[true, false, false];
    return ToggleButtons(
      isSelected: isSelected,
      onPressed: (index){},
      children: const [
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Row(
            children: [
              Icon(Icons.add),
              Text('登録する')
            ],
          ),
        ),
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 2'),
        ),
        Padding(
          padding: EdgeInsets.all(10.0),
          child: Text('Button 3'),
        ),
      ],
    );
  }
}