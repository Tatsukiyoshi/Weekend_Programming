import 'package:flutter/material.dart';

class ScaffoldBottomSheet extends StatelessWidget{
  const ScaffoldBottomSheet({super.key});


	@override
	Widget build(BuildContext context) {

		return Scaffold(
			appBar: AppBar(
				title: const Text("APP BAR Sample 1"),
				leading: IconButton(
					icon: const Icon(Icons.menu),
					onPressed: (){

					},
				),

			),
			body: Center(
					child: Builder(
						builder: (context) => TextButton(
								child: const Text("Open Bottom Sheet"),
								onPressed: (){
									Scaffold.of(context).showBottomSheet((BuildContext context) {
										return Container(
											height: 100,
											color: Colors.amber,
											child: Center(
												child: TextButton(
													child: const Text("Bottom Sheet"),
													onPressed: (){
														Navigator.pop(context);
													},
												),
											),
										);
									});
								}
						),
					)
			),
			bottomNavigationBar: BottomNavigationBar(
				items: const [
					BottomNavigationBarItem(
							icon: Icon(Icons.home),
							label: "HOME",
							backgroundColor: Colors.black
					),
					BottomNavigationBarItem(
							icon: Icon(Icons.star),
							label : "MY Page",
							backgroundColor: Colors.black
					),
					BottomNavigationBarItem(icon: Icon(Icons.calendar_today),label: "スケジュール",backgroundColor: Colors.black),
					BottomNavigationBarItem(icon: Icon(Icons.settings) , label: "設定",backgroundColor: Colors.black)
				],
			),
			floatingActionButton: FloatingActionButton(
				tooltip: "追加する",
				onPressed: (){

				},
				child: const Icon(Icons.add),
			),
		);
	}
}