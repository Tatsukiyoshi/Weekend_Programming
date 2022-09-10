import 'package:flutter/material.dart';
import 'package:sample_app/sample2/home_page.dart';

class MyApp2 extends StatelessWidget {
  const MyApp2({super.key});

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
