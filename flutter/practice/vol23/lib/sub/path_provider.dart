import 'dart:io';
import 'package:flutter/foundation.dart';
import 'package:path_provider/path_provider.dart';

Future<void> pathProvider() async{

  Directory dir1 = await getTemporaryDirectory();
  Directory dir2 = await getApplicationSupportDirectory();
  Directory dir3 = await getApplicationDocumentsDirectory();

  if (kDebugMode) {
    print("getTemporaryDirectory : ${dir1.path}");
    print("getApplicationSupportDirectory : ${dir2.path}");
    print("getApplicationDocumentsDirectory : ${dir3.path}");
  }
}
