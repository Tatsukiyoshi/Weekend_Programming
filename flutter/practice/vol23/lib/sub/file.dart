import 'dart:io';
import 'package:flutter/foundation.dart';
import 'package:path_provider/path_provider.dart';

Future<void> createDirAndFile() async{
  Directory dir = await getApplicationSupportDirectory();

  //  (1) ディレクトリの確認と作成
  Directory subdir = Directory("${dir.path}/subdir");
  if(!subdir.existsSync()){
    subdir.createSync();
  }

  //  (2) ファイルへの文字列の書き込み
  File file = File("${subdir.path}/sample.txt");
  file.writeAsString("Hello World");

  readFile();
}

Future<void> readFile() async{
  Directory dir = await getApplicationSupportDirectory();

  File file = File("${dir.path}/subdir/sample.txt");
  // (3) ファイルの読み込み
  String text = await file.readAsString();
  if (kDebugMode) {
    print("----- ${text} ----");
  }
}
