import 'package:flutter/material.dart';

// https://api.flutter.dev/flutter/material/AppBar-class.html
// https://api.flutter.dev/flutter/material/BottomNavigationBar-class.html

class ScaffoldSample extends StatelessWidget{
  const ScaffoldSample({super.key});

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
						child: const Text("BODY"),
						onPressed: () => print('Clicked'),
					)
			),
			bottomNavigationBar: BottomNavigationBar(
				type: BottomNavigationBarType.shifting,

				items: const [
					BottomNavigationBarItem(
							icon: Icon(Icons.home),
							label: "ホーム",
							backgroundColor: Colors.black
					),
					BottomNavigationBarItem(
							icon: Icon(Icons.star),
							label : "マイページ",
							backgroundColor: Colors.black
					),
					BottomNavigationBarItem(icon: Icon(Icons.calendar_today),label: "スケジュール",backgroundColor: Colors.black),
					BottomNavigationBarItem(icon: Icon(Icons.settings) , label: "設定",backgroundColor: Colors.black)
				],
				currentIndex: 2,
				onTap: (int idx){
					//	ボタンがタップされたときの処理
				},
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