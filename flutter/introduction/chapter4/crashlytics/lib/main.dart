import 'dart:async';
import 'dart:core';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';
import 'package:firebase_crashlytics/firebase_crashlytics.dart';

Future<void> main() async {
  await runZonedGuarded(() async {
    WidgetsFlutterBinding.ensureInitialized();
    await Firebase.initializeApp(
      options: DefaultFirebaseOptions.currentPlatform,
    );
    // Flutterでキャッチされた例外／エラー
    FlutterError.onError = FirebaseCrashlytics.instance.recordFlutterError;
    runApp(const MyApp());
  }, (error, stackTrace) {
    // Flutterでキャッチされなかった例外／エラー
    FirebaseCrashlytics.instance.recordError(error, stackTrace);
  });
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
            child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // 例外を発生させるボタン
            ElevatedButton(
              onPressed: () {
                FirebaseCrashlytics.instance.log('ExceptionLog');
                throw Exception('MyException');
              },
              child: const Text('Throw Error'),
            ),
            ElevatedButton(
              onPressed: () {
                FirebaseCrashlytics.instance.log('CrashLog');
                FirebaseCrashlytics.instance.crash();
              },
              child: const Text('Crash'),
            ),
          ],
        )));
  }
}
