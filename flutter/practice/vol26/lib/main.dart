import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:logger/logger.dart';
import 'package:vol26/ContainerScreen.dart';
import 'package:vol26/child/ListViewPage.dart';
import 'package:vol26/child/LocalKeyScreen.dart';
import 'package:vol26/child/LoggerPage.dart';
import 'package:vol26/child/MyFormPage.dart';
import 'package:vol26/child/PageStorageKeyPage.dart';
import 'package:vol26/logger/LoggerWidget.dart';

void main() {
  runApp(const MyApp());
}

final GlobalKey<NavigatorState> _rootNavigatorKey = GlobalKey<NavigatorState>(debugLabel: 'root');
final GlobalKey<NavigatorState> _shellNavigatorKey = GlobalKey<NavigatorState>(debugLabel: 'shell');

var logger = Logger(
  printer: PrettyPrinter(),
);

final GoRouter _router = GoRouter(
  navigatorKey: _rootNavigatorKey,
  initialLocation: '/sample1',
  debugLogDiagnostics: true,
  routes: [
    ShellRoute(
        navigatorKey: _shellNavigatorKey,
        builder: (context,state,child){
          return ContainerScreen(child: child);
        },
        routes: [
          GoRoute(
              path : '/sample1',
              name : 'sample1',
              builder: (context,state) => const ListViewPage()
          ),
          GoRoute(
              path: '/sample2',
              name : 'sample2',
              builder: (context,state) => const LocalKeyPage()
          ),
          GoRoute(
              path: '/sample3',
              name : "sample3",
              builder: (context,state) => const PageStorageKeyPage()
          ),
          GoRoute(
              path: '/sample4',
              builder : (context,state) => const MyFormPage()
          )
        ]
    )
  ]
);

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    logger.d("------- start -------");
    return LoggerWidget(
        theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
          useMaterial3: true,
        ),
        log : logger,
        child: MaterialApp.router(
            debugShowCheckedModeBanner: false,
            routerConfig: _router,
        )
    );
  }
}