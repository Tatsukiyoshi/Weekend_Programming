import 'package:flutter/material.dart';

// https://api.flutter.dev/flutter/material/AppBar-class.html
// https://api.flutter.dev/flutter/material/BottomNavigationBar-class.html

class ScaffoldSample extends StatelessWidget{
	@override
	Widget build(BuildContext context) {
		return Scaffold(
			appBar: AppBar(
				title: Text("APP BAR Sample 1"),
				leading: IconButton(
					icon: Icon(Icons.menu),
					onPressed: (){

					},
				),

			),
			body: Center(
					child: TextButton(
						child: Text("BODY"),
					)
			),
			bottomNavigationBar: BottomNavigationBar(
				type: BottomNavigationBarType.shifting,

				items: [
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
				child: Icon(Icons.add),
				tooltip: "追加する",
				onPressed: (){

				},
			),
		);
	}
}