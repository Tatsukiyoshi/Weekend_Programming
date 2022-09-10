import 'package:flutter/material.dart';
import 'package:sample_app/sample2/third_page.dart';

class SecondPage extends StatelessWidget{
  const SecondPage({super.key});

	@override
	Widget build(BuildContext context) {
		return Scaffold(
				appBar: AppBar(
						title : const Text("ページ(2)")
				),
				body : Center(
					child: TextButton(
						child: const Text("３ページへ"),
						onPressed: (){
							Navigator.push(context,
									MaterialPageRoute(
										builder: (context) => ThirdPage()
									));
						},
					),
				)
		);
	}
}
