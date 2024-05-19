import 'package:flutter/material.dart';

// https://api.flutter.dev/flutter/material/AppBar-class.html
// https://api.flutter.dev/flutter/material/BottomNavigationBar-class.html

class ScaffoldSnackBar extends StatelessWidget{
  const ScaffoldSnackBar({super.key});

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
					child: TextButton(
						child: const Text("Message"),
						onPressed: (){
							ScaffoldMessenger.of(context).showSnackBar(
									SnackBar(
										content: const Text("Hello"),
										behavior: SnackBarBehavior.floating,
										duration: const Duration(seconds: 5),

										backgroundColor: Colors.red,
										padding: const EdgeInsets.all(10.0),
										shape: RoundedRectangleBorder(
											borderRadius: BorderRadius.circular(10.0),
										),
									)
							);
						},
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