import 'dart:io';
import 'package:flutter/foundation.dart';
import 'package:path_provider/path_provider.dart';
import 'package:http/http.dart' as http;

Future<void> saveHttpData() async{
  var tmpDir = await getTemporaryDirectory();
  var tmpId = DateTime.now().millisecondsSinceEpoch;
  var tmpFile = File('${tmpDir.path}/$tmpId.png');

  var client = http.Client();
  var req = http.Request('GET',Uri.parse("http://192.168.1.1/chat/avatar/1.png"));
  var res = await client.send(req);

  res.stream.listen((value){
    tmpFile.writeAsBytesSync(value,mode: FileMode.append);
  }).onDone(() async{
    var len = tmpFile.lengthSync();
    if (kDebugMode) {
      print(" done bytes ... ($len) -> ${tmpFile.path}");
    }
    client.close();
  });
}
