import 'package:flutter/material.dart';
import 'package:vol10/ProductItem.dart';
import 'package:vol10/page/ProductItemPage.dart';
import 'package:vol10/page/ProductListPage.dart';

class MainApp1 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _MainApp1();
}

class _MainApp1 extends State<MainApp1> {
  //	(1) 詳細画面として表示する場合のデータ
  ProductItem _selectedItem;

  //  (2) ProductListPageでListをタップしたときに呼ばれるメソッド
  void _onTapItem(ProductItem item) {
    setState(() {
      _selectedItem = item;
    });
  }

  //	(3) 管理しているデータ
  List<ProductItem> items = [
    ProductItem("id1", "商品A"),
    ProductItem("id2", "商品B")
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Nav2 Sample 1',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        //	(4) 最初のページとしてNavigatorクラスを指定する
        home: Navigator(
          // (5) 表示する画面スタック
          pages: [
            MaterialPage(child: ProductListPage(this.items, _onTapItem)),
            //	(6) 詳細画面を表示する時には、画面を追加する
            if (_selectedItem != null)
              MaterialPage(child: ProductItemPage(_selectedItem)),
          ],
          //  (7) popが呼ばれたときの処理 ( pages[]を指定したら、必ず必要です )
          onPopPage: (route, result) {
            if (!route.didPop(result)) {
              return false;
            }
            setState(() {
              _selectedItem = null;
            });
            return true;
          },
        ));
  }
}
