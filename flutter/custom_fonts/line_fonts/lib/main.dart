import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Custom Fonts',
      // Set LINESeedJP font as the default app font.
      theme: ThemeData(fontFamily: 'App'),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // The AppBar uses the app-default font.
      appBar: AppBar(title: const Text('Custom Fonts')),
      body: const Center(
        // This Text widget uses the LINE font.
        child: Text(
          'Roboto Mono sample',
          style: TextStyle(fontFamily: 'App'),
        ),
      ),
    );
  }
}
