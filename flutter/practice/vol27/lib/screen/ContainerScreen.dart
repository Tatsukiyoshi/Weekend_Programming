import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class ContainerScreen extends StatelessWidget{

  final Widget child;

  const ContainerScreen({
    required this.child,
    super.key
  });

  @override
  Widget build(BuildContext context) {
    if (kDebugMode) {
      print(context);
    }
    return Scaffold(
      body: child,
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _calculateSelectedIndex(context),
        items : const [
          BottomNavigationBarItem(
              icon: Icon(Icons.list),
            label: '1'
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.list),
            label: '2'
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.list),
              label: '3'
          )
        ],
        onTap: (index){
          _onTapItem(index,context);
        },
      ),
    );
  }

  static int _calculateSelectedIndex(BuildContext context) {
    final String location = GoRouterState.of(context).uri.toString();
    if (location.startsWith('/sample1')) {
      return 0;
    }
    if (location.startsWith('/sample2')) {
      return 1;
    }
    if (location.startsWith('/sample3')) {
      return 2;
    }
    return 0;
  }

  void _onTapItem(int index,BuildContext context){
    switch(index){
      case 0:
        context.go('/sample1');
        break;
      case 1:
        context.go('/sample2');
        break;
      case 2:
        context.go('/sample3');
        break;
    }
  }
}