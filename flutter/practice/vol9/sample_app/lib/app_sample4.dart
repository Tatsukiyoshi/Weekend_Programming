import 'package:flutter/material.dart';
import 'package:sample_app/sample4/item_page.dart';
import 'package:sample_app/sample4/list_page.dart';

class MyApp4 extends StatelessWidget {
  const MyApp4({super.key});

	@override
	Widget build(BuildContext context) {
		return MaterialApp(
				title: 'Flutter List/Item Page',
				debugShowCheckedModeBanner: false,
				theme: ThemeData(
					primarySwatch: Colors.blue,
				),
				initialRoute: '/',
				onGenerateRoute: (RouteSettings settings){

					if(settings.name == null || settings.name == '/'){
						return MaterialPageRoute(
								builder: (context) => const ListPage()
						);
					}

					//  /detail/{id} のようなURL
					var uri = Uri.parse(settings.name!);
					var id = uri.pathSegments[1];

					return MaterialPageRoute(
						builder: (context) {
							return ItemPage(
									id : id
							);
						},
					);
				}
		);
	}
}
