import 'package:flutter/material.dart';
import 'package:sample_app/sample3/first_page.dart';
import 'package:sample_app/sample3/second_page.dart';
import 'package:sample_app/sample3/args_page.dart';

class MyApp3 extends StatelessWidget {
  const MyApp3({super.key});

	@override
	Widget build(BuildContext context) {
		return MaterialApp(
				title: 'Flutter Demo',
				debugShowCheckedModeBanner: false,
				theme: ThemeData(
					primarySwatch: Colors.blue,
				),
				// (1) 最初のページ名
				initialRoute: '/first',
				// (2) ページ名とウィジェットの関係
				routes: {
					'/first' : (context) => const FirstPage(),
					'/second' : (context) => const SecondPage(),
					'/args' : (context) => const ArgsPage(),
				}
		);
	}
}
