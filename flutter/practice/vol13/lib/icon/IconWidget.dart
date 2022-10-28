import 'package:flutter/material.dart';

class IconWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {

    return Container(
      color: Colors.white,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(
            Icons.home_outlined,
          ),
          Icon(
            Icons.home,
            size: 40,
            color: Colors.blueAccent,
          ),
          Icon(
            Icons.account_box,
            color: Colors.redAccent,
            size: 45,
          )
        ],
      ),
    );
  }

}