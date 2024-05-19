import 'package:flutter/material.dart';
import 'package:vol10/AppRoutePath.dart';

class ItemRouterInformationParser extends RouteInformationParser<AppRoutePath> {
	// (1) パスが変更された時の処理
  @override
  Future<AppRoutePath> parseRouteInformation(
      RouteInformation routeInformation) async {

    if (routeInformation.uri.toString() == '/') {
      return AppRoutePath.list();
    } else {
    	// (2) /id1 のような入力になるので、最初の"/"をとる
      var id = routeInformation.uri.toString().substring(1);
      return AppRoutePath.item(id);
    }
  }

  //	(3) 状態が変わったときに、パスを反映する処理
  @override
  RouteInformation restoreRouteInformation(AppRoutePath configuration) {
    if (configuration.id != null) {
      //	(4) アイテムが設定されている場合のURLを設定する
      return RouteInformation(uri: '/${configuration.id}');
    }
    return const RouteInformation(location: '/');
  }
}