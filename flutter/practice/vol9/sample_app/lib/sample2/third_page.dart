import 'package:flutter/material.dart';

class ThirdPage extends StatelessWidget{
  const ThirdPage({super.key});

	@override
	Widget build(BuildContext context) {
		return Scaffold(
				appBar: AppBar(
						title : const Text("ページ(3)")
				),
				body : Center(
					child: TextButton(
						child: const Text("最初のページにもどる"),
						onPressed: (){
							Navigator.popUntil(context, (route) => route.isFirst);
						},
					),
				)
		);
	}
}
