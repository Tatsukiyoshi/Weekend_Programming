import 'package:flutter/material.dart';
import 'package:vol10/ProductItem.dart';

class ProductItemPage extends StatelessWidget {
	final ProductItem item;

  const ProductItemPage(this.item);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
			appBar: AppBar(
				title : Text(item.title)
			),
			body: Center(
				child: Text("詳細ページ",style: TextStyle(fontSize: 25),),
			),
		);
  }
}