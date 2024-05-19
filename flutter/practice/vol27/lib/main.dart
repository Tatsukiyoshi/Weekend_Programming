import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:vol27/screen/ContainerScreen.dart';
import 'package:vol27/screen/LineChartScreen.dart';
import 'package:vol27/screen/Sample1Screen.dart';
import 'package:vol27/screen/TouchRectScreen.dart';

void main() {
  runApp(const MyApp());
}

final GlobalKey<NavigatorState> _rootNavigatorKey = GlobalKey<NavigatorState>(debugLabel: 'root');
final GlobalKey<NavigatorState> _shellNavigatorKey = GlobalKey<NavigatorState>(debugLabel: 'shell');

final GoRouter _router = GoRouter(
    navigatorKey: _rootNavigatorKey,
    initialLocation: '/sample1',
    debugLogDiagnostics: true,
    routes: [
      ShellRoute(
          navigatorKey: _shellNavigatorKey,
          builder: (context, state, child){
            return ContainerScreen(child: child);
          },
          routes: [
            GoRoute(
                name : 'sample1',
                path : '/sample1',
                builder: (context,state){
                  return const Sample1Screen();
                }
            ),
            GoRoute(
                name : 'sample2',
                path : '/sample2',
                builder: (context,state){
                  return const LineChartScreen();
                }
            ),
            GoRoute(
                name : 'sample3',
                path : '/sample3',
                builder: (context,state){
                  return const TouchRectScreen();
                }
            )
          ]
      )
    ]);


class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      debugShowCheckedModeBanner: false,
      routerConfig: _router,
    );
  }
}
