import 'package:flutter/material.dart';
import 'package:vol9/sample1/home_page.dart';

class MyApp1 extends StatelessWidget {
  const MyApp1({super.key});

	@override
	Widget build(BuildContext context) {
		return MaterialApp(
			title: 'Flutter Sample1',
			debugShowCheckedModeBanner: false,
			theme: ThemeData(
				primarySwatch: Colors.blue,
			),
			home: const HomePage(),
		);
	}
}
