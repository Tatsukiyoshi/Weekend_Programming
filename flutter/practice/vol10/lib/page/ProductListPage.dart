import 'package:flutter/material.dart';
import 'package:vol10/ProductItem.dart';

class ProductListPage extends StatelessWidget{

	final List<ProductItem> items;
	final ValueChanged<ProductItem> onTapItem;

	ProductListPage(this.items,this.onTapItem);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
		return Scaffold(
			appBar: AppBar(
				title: Text("プロダクト一覧"),
			),
			body: ListView(
				children: [
					for(var item in items)
						ListTile(
							title: Text(item.title,
							style: TextStyle(fontSize: 25),),
							onTap: () => onTapItem(item),
						)
				],
			),
		);
  }


}