import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';

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
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a purple toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  // 入力したメールアドレスとパスワード
  String _email = '';
  String _password = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
            child: Container(
                padding: const EdgeInsets.all(24),
                child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      // 1行目 メールアドレス入力用テキストフィールド
                      TextFormField(
                        decoration: const InputDecoration(labelText: 'メールアドレス'),
                        onChanged: (String value) {
                          setState(() {
                            _email = value;
                          });
                        },
                      ),
                      // 2行目 パスワード入力用テキストフィールド
                      TextFormField(
                        decoration: const InputDecoration(labelText: 'パスワード'),
                        obscureText: true,
                        onChanged: (String value) {
                          _password = value;
                        },
                      ),
                      // 3行目 ユーザ登録ボタン
                      ElevatedButton(
                        child: const Text('ユーザ登録'),
                        onPressed: () async {
                          try {
                            final User? user = (await FirebaseAuth.instance
                                    .createUserWithEmailAndPassword(
                                        email: _email, password: _password))
                                .user;
                            if (user != null)
                              print("ユーザ登録しました ${user.email}, ${user.uid}");
                          } catch (e) {
                            print(e);
                          }
                        },
                      ),
                      // 4行目 ログインボタン
                      ElevatedButton(
                          child: const Text('ログイン'),
                          onPressed: () async {
                            try {
                              final User? user = (await FirebaseAuth.instance
                                      .signInWithEmailAndPassword(
                                          email: _email, password: _password))
                                  .user;
                              if (user != null)
                                print("ログインしました ${user.email}, ${user.uid}");
                            } catch (e) {
                              print(e);
                            }
                          }),
                      // 5行目 パスワードリセット登録ボタン
                      ElevatedButton(
                          child: const Text('パスワードリセット'),
                          onPressed: () async {
                            try {
                              await FirebaseAuth.instance
                                  .sendPasswordResetEmail(email: _email);
                              print("パスワードリセット用のメールを送信しました");
                            } catch (e) {
                              print(e);
                            }
                          })
                    ]))));
  }
}
