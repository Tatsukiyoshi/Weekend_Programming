import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(const MyApp());
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
          child: TextButton(
        onPressed: () {
          // リスト4.10/4.11
          FirebaseFirestore.instance
              .collection('flutterDataCollection')
              .doc('flutterDataDocument')
              .get()
              .then((ref) {
            if (kDebugMode) {
              print(ref.get("mydata"));
            }
            // リスト4.12
            FirebaseFirestore.instance
                .doc('autoCollection1/autoDocument1')
                .set({'autofield': "abc"});
            // リスト4.14
            FirebaseFirestore.instance
                .collection('autoCollection2')
                .add({'autofield': "xyz"});
            // リスト4.15
            FirebaseFirestore.instance
                .doc('autoCollection1/autoDocument1')
                .delete();
          });
        },
        child: const Text(
          '実行',
          style: TextStyle(fontSize: 50),
        ),
      )),
    );
  }
}
