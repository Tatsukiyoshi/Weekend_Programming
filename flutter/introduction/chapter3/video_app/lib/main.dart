import 'dart:io';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:video_player/video_player.dart';

void main() {
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
  VideoPlayerController? _controller;
  final imagePicker = ImagePicker();

  // カメラから動画を取得するメソッド
  Future getVideoFromCamera() async {
    XFile? pickedFile = await imagePicker.pickVideo(source: ImageSource.camera);
    if (pickedFile != null) {
      _controller = VideoPlayerController.file(File(pickedFile.path));
      _controller!.initialize().then((_) {
        setState(() {
          _controller!.play();
        });
      });
    }
  }

  // ギャラリーから動画を取得するメソッド
  Future getVideoFromGallary() async {
    XFile? pickedFile =
        await imagePicker.pickVideo(source: ImageSource.gallery);
    if (pickedFile != null) {
      _controller = VideoPlayerController.file(File(pickedFile.path));
      _controller!.initialize().then((_) {
        setState(() {
          _controller!.play();
        });
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
            child: _controller == null
                ? Text(
                    '動画を選択してください',
                    style: Theme.of(context).textTheme.headlineMedium,
                  )
                : VideoPlayer(_controller!)),
        floatingActionButton:
            Row(mainAxisAlignment: MainAxisAlignment.spaceEvenly, children: [
          // カメラから取得するボタン
          FloatingActionButton(
              onPressed: getVideoFromCamera,
              child: const Icon(Icons.video_call)),
          // ギャラリーから取得するボタン
          FloatingActionButton(
              onPressed: getVideoFromGallary,
              child: const Icon(Icons.movie_creation))
        ]));
  }
}
