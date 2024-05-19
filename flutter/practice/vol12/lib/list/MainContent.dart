import 'package:flutter/material.dart';

@immutable
class MainContent extends StatelessWidget{

  final Function onPressed;
  const MainContent(this.onPressed, {super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const SizedBox(
          height: 20,
          child : Align(
            alignment: Alignment.centerLeft,
            child: Padding(
                padding: EdgeInsets.all(2),
                child: FittedBox(
                  fit: BoxFit.contain,
                  child: Text("タイトル",
                    style: TextStyle(
                        color: Colors.black,
                        decoration: TextDecoration.none,
                        fontWeight: FontWeight.normal
                    ),
                  ),
                )
            ),
          )
        ),

        Expanded(
          child: Container(
          color: Colors.grey.shade300,
          )
        ),
        Container(
          height: 20,
          padding: const EdgeInsets.symmetric( horizontal: 5, vertical: 2),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ElevatedButton(
                  onPressed: () => { onPressed() },
                  style: ButtonStyle(
                      backgroundColor: WidgetStateProperty.all<Color>(Colors.red),
                      foregroundColor: WidgetStateProperty.all<Color>(Colors.white),
                      shape: WidgetStateProperty.all<RoundedRectangleBorder>(
                          RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(5.0),
                              side: const BorderSide(color: Colors.red)
                          )
                      )
                  ),
                  child: const Padding(
                      padding: EdgeInsets.all(2),
                      child: FittedBox(
                        fit: BoxFit.contain,
                        child: Text("詳細を見る"),
                      )
                  )
              ),
              const Padding(
                padding: EdgeInsets.only(top: 5),
                child: FittedBox(
                  fit: BoxFit.fitHeight,
                  child: Text("2021/07/21",
                    style: TextStyle(
                        color: Colors.black,
                        decoration: TextDecoration.none,
                        fontWeight: FontWeight.normal
                    ),
                  ),
                )
              )
            ],
          ),
        )
      ],
    );
  }
}