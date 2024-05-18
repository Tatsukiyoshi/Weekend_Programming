import 'package:flutter/material.dart';
import 'package:vol24/data/DateItem.dart';

class DateBlock extends StatelessWidget{

  final DateItem item;

  const DateBlock({
    required this.item,
    super.key
  });

  @override
  Widget build(BuildContext context) {
    return Expanded(
      flex: (item.today)? 3: 2,
      child : Container(
        decoration: _itemDecoration(),
          child : Row(
            children: [
              Container(
                decoration: BoxDecoration(
                  border: Border(
                    right: (item.today)? const BorderSide(
                      color: Colors.grey, width: 1
                    ) : const BorderSide(
                      color: Colors.white,width: 1
                    )
                  ),
                  color: (item.today) ? Colors.white : Colors.grey,
                ),
                width: 50,
                child: Column(
                  children: [
                    Text('${item.day}',
                      style: Theme.of(context).textTheme.headlineMedium?.apply(
                        color: (item.today)? Colors.black : Colors.white
                      ),
                    ),
                    Text('(${item.week})',
                      style: TextStyle(
                        color: (item.today)? Colors.black : Colors.white
                      ),
                    ),
                  ],
                ),
              ),
              Expanded(
                child: Container(
                  padding: const EdgeInsets.all(10),
                  child : Text(item.text),
                ),
              )
            ],
          )
      )

    );
  }

  BoxDecoration _itemDecoration() {
    if (item.today) {
      return const BoxDecoration(
          color: Colors.white,
          border: Border(
              top: BorderSide(
                  color: Colors.redAccent,
                  width: 5
              ),
              bottom: BorderSide(
                  color: Colors.redAccent,
                  width: 5
              )
          )
      );
    }
    else {
      return const BoxDecoration(
          color: Colors.white70,
          border: Border(
              bottom: BorderSide(
                  color: Colors.black26,
                  width: 1
              )
          )
      );
    }
  }
}