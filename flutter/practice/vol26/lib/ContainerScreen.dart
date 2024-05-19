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
    return Scaffold(
      body: child,
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: _calculateSelectedIndex(context),
        items : const [
          BottomNavigationBarItem(
              icon: Icon(Icons.list), label: '1'
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.list), label: '2'),
          BottomNavigationBarItem(
              icon: Icon(Icons.list), label : '3'),
          BottomNavigationBarItem(
              icon: Icon(Icons.text_fields), label : '4')
        ],
        onTap: (index){
          _onTapItem(index, context);
        },
      ),
    );
  }

  static int _calculateSelectedIndex(BuildContext context) {
    final GoRouterState state = GoRouterState.of(context);
    if (kDebugMode) {
      print("location ${state.matchedLocation} - ${state.name}");
    }
    if(state.matchedLocation.startsWith("/sample1")){
      return 0;
    }
    else if(state.matchedLocation.startsWith("/sample2")){
      return 1;
    }
    else if(state.matchedLocation.startsWith("/sample3")){
      return 2;
    }
    else{
      return 3;
    }
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
      case 3:
        context.go('/sample4');
        break;
    }
  }
}