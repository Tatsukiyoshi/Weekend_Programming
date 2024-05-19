import 'package:flutter/material.dart';

class ColumnWidget extends StatelessWidget{
  const ColumnWidget({super.key});


	@override
  Widget build(BuildContext context) {
		return Column(
			mainAxisAlignment: MainAxisAlignment.center,
			crossAxisAlignment: CrossAxisAlignment.start,
			children: [
				childContainer(100, 100),
				childContainer(200, 100),
				childContainer(100, 200),
				childContainer(200, 200),
			],
		);
  }

  Widget childContainer(double width,double height){
		return Container(
			margin: const EdgeInsets.all(10),
			width: width,
			height: height,
			color: Colors.blue,
		);
	}
}