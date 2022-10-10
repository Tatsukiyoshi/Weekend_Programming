import 'package:flutter/material.dart';
import 'package:vol10/AppRoutePath.dart';
import 'package:vol10/page/ProductItemPage.dart';
import 'package:vol10/page/ProductListPage.dart';
import 'package:vol10/ProductItem.dart';

// (1) RouterDelegateの実装クラスを作成する
class ItemRouterDelegate extends RouterDelegate<AppRoutePath>
    with ChangeNotifier, PopNavigatorRouterDelegateMixin<AppRoutePath> {
  final GlobalKey<NavigatorState> navigatorKey;

  ProductItem _selectedItem;

  List<ProductItem> items = [
    ProductItem("id1", "商品A"),
    ProductItem("id2", "商品B")
  ];

  ItemRouterDelegate() : navigatorKey = GlobalKey<NavigatorState>();

  //  (2) 表示するアイテムが選択されたときの処理
  void _onTapItem(ProductItem item) {
    _selectedItem = item;
    //	(3) 変更通知をする
    notifyListeners();
  }

  @override
  Widget build(BuildContext context) {
    return Navigator(
      key: navigatorKey,
      pages: [
        MaterialPage(
            key: ValueKey('ProductListPage'),
            child: ProductListPage(items, _onTapItem)),
        if (_selectedItem != null)
          MaterialPage(child: ProductItemPage(_selectedItem))
      ],
      onPopPage: (route, result) {
        print('on pop page');
        if (!route.didPop(result)) {
          return false;
        }
        _selectedItem = null;
        //	(4) 変更通知をする
        notifyListeners();
        return true;
      },
    );
  }

  //	(5) 新しいパスが設定されたとき
  @override
  Future<void> setNewRoutePath(AppRoutePath path) async {
    if (path.isItemPage) {
      //	パスに従った詳細ページ用のデータを設定する
      _selectedItem = items.firstWhere((element) => element.id == path.id);
    }
    return;
  }

  //	(6) 現在の状態をパスで表現した場合
  AppRoutePath get currentConfiguration => _selectedItem == null
      ? AppRoutePath.list()
      : AppRoutePath.item(_selectedItem.id);
}