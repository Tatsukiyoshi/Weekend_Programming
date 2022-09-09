import 'package:flutter/material.dart';

class ScaffoldEndDrawer extends StatelessWidget{

	@override
	Widget build(BuildContext context) {
		return Scaffold(
			appBar: AppBar(
				title: Text("タイトル"),
			),
			body: Center(
					child: TextButton(
						child: Text("BODY"),
					)
			),
			endDrawer: Drawer(
				child: ListView(
					children: [
						DrawerHeader(child: Text("Header")),
						ListTile(
							title: Text("Item 1"),
						),
						ListTile(
							title: Text("Item 2"),
						)
					],
				),
			),
			bottomNavigationBar: BottomNavigationBar(
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
			),
		);
	}
}