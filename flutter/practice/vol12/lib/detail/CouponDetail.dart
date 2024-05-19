//import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

@immutable
class CouponDetail extends StatelessWidget {

  final Function closeAction;
  const CouponDetail(this.closeAction, {super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
        color: const Color.fromRGBO(0, 0, 0, 0.5),
        child: Center(
            child: Padding(
          padding: const EdgeInsets.all(20),

          //  外枠を表示
          child: Container(
            margin: const EdgeInsets.all(20),
            padding: const EdgeInsets.all(20),
            decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(10),
                color: Colors.white,
                boxShadow: const [BoxShadow(color: Colors.grey, blurRadius: 5)]),
            //  コンテンツの中身を表示
            child: mainContent(),
          ),
        )));
  }

  // コンテンツの中身
  Widget mainContent(){
    return Column(
      //  表示するサイズを最小にする
      mainAxisSize: MainAxisSize.min,
      children: [
        Image.asset('assets/images/c_img.jpg'),
        mainCenterContent(),
        mainBottomContent(),
      ],
    );
  }

  Widget mainCenterContent(){

    return Container(
      margin: const EdgeInsets.only(top: 10),
      height: 80,
      color: Colors.grey,
    );
  }

  Widget mainBottomContent(){
    return Padding(
      padding: const EdgeInsets.all(10),
      child: Center(
        child: Row(
          children: [
            const Spacer(
              flex: 1,
            ),
            Expanded(
                flex: 2,
                child: ElevatedButton(
                    onPressed: () => {closeAction()},
                    style: ButtonStyle(
                        backgroundColor:
                        WidgetStateProperty.all<Color>(
                            Colors.red),
                        foregroundColor:
                        WidgetStateProperty.all<Color>(
                            Colors.white),
                        shape: WidgetStateProperty.all<
                            RoundedRectangleBorder>(
                            RoundedRectangleBorder(
                                borderRadius:
                                BorderRadius.circular(5.0),
                                side: const BorderSide(
                                    color: Colors.red)))),
                    child: const Padding(
                        padding: EdgeInsets.all(2),
                        child: FittedBox(
                          fit: BoxFit.contain,
                          child: Text("閉じる"),
                        )))),
            const Spacer(
              flex: 1,
            )
          ],
        ),
      ),
    );
  }
}
