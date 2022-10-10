import 'package:flutter/material.dart';
import 'package:vol12/detail/CouponDetail.dart';
import 'package:vol12/list/CouponListView.dart';

class MainPageWidget extends StatefulWidget{
  const MainPageWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    return _MainPageWidget();
  }
}

class _MainPageWidget extends State<MainPageWidget>{

  bool _isSelectedItem = false;

  // 詳細画面を表示する
  void openDetail(){
    setState(() {
      _isSelectedItem = true;
    });
  }
  // 詳細画面を消す
  void closeDetail(){
    setState(() {
      _isSelectedItem = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        CouponListView(openDetail),
        if (_isSelectedItem)
          CouponDetail(closeDetail)
      ],
    );
  }
}
