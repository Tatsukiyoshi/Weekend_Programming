import 'package:flutter/material.dart';
import 'package:layout_sample/list/CouponListItem.dart';

class CouponListView extends StatelessWidget{

  final Function onPressed;
  CouponListView(this.onPressed, {super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.white,
        child: listViewBuilder()
    );
  }

  Widget buildListView(){
    return ListView(
      children: [
        CouponListItem(onPressed),
        CouponListItem(onPressed),
        CouponListItem(onPressed),
      ],
    );
  }


  //  データの個数に従って、表示する場合
  final items = [0,1,2,3,4,5,6];

  Widget listViewBuilder(){
    return ListView.builder(
      itemCount: items.length,
        itemBuilder: (BuildContext context, int index) {
          return CouponListItem(onPressed);
        }
    );
  }
}