import 'package:flutter/material.dart';

class AppBarSample extends StatefulWidget {
  const AppBarSample({super.key});


	@override
	_AppBarSample createState() => _AppBarSample();
}

class _AppBarSample extends State<AppBarSample>
	with TickerProviderStateMixin {

	late TabController _tabController;

	@override
	void initState() {
    super.initState();
		_tabController = TabController(length: 3, vsync: this);
  }

	@override
	Widget build(BuildContext context) {

		return Scaffold(
			appBar: AppBar(
				title: const Text("タイトル"),
				centerTitle: true,

				backgroundColor: Colors.lightGreen,

				//	左アイコン
				leading: IconButton(
					icon: const Icon(Icons.menu),
					onPressed: (){

					},
				),
				//	右アイコン
				actions: [
					IconButton(icon: const Icon(Icons.list_alt), onPressed: (){}),
					IconButton(icon: const Icon(Icons.add_shopping_cart), onPressed: (){})
				],

				//	下部の設定
				bottom: TabBar(
					controller: _tabController,
					indicatorColor: Colors.green.shade700,
					indicatorWeight: 5.0,
					tabs: const [
						Tab(
							icon: Icon(Icons.agriculture_rounded),
						),
						Tab(
							icon: Icon(Icons.cake)
						),
						Tab(
							icon : Icon(Icons.settings)
						)
					],
				),
			),
			body: Center(
					child: TextButton(
						child: const Text("BODY"),
						onPressed: () => print('Clicked')
					)
			)
		);
	}
}