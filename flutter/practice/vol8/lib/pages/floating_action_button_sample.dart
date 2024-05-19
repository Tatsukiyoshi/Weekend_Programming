import 'package:flutter/material.dart';

//
//   FloatingActionButtonを下部メニューと合体させたような見せ方
//
class FloatingActionButtonSample extends StatelessWidget{
  const FloatingActionButtonSample({super.key});

	@override
	Widget build(BuildContext context) {
		return Scaffold(
			body: Center(
					child: TextButton(
						child: const Text("BODY"),
						onPressed: () => print('Clicked'),
					)
			),
			floatingActionButton: FloatingActionButton(
				tooltip: "メニューを開く",
				onPressed: (){

				},
				child: const Icon(Icons.apps),
			),
			floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,

			bottomNavigationBar: BottomAppBar(
				clipBehavior: Clip.antiAliasWithSaveLayer,
				shape: const CircularNotchedRectangle(),
				notchMargin: 5.0,
				child: Container(
					height: 80,
					color: Colors.red,
				),
			),
		);
	}
}