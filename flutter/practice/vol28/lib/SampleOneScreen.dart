import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:logger/logger.dart';
import 'package:http/http.dart' as http;

class _SampleOneScreen extends State<SampleOneScreen>{
  @override
  void initState() {
    super.initState();
    sample6Logger();
  }

  void sample1Logger(){
    var log = Logger();

    try {
      log.d("debug message");
      log.i("info message");
      throw StateError("state error");
    }
    catch(e){
      log.w("error ",error: e);
    }
  }

  void sample2Logger(){
    Logger.level = Level.info;
    var log = Logger(
      level: Level.warning
    );

    try {

      log.d("debug message");
      log.i("info message");
      throw StateError("state error");
    }
    catch(e){
      log.w("error ",error: e);
    }
  }

  void sample3Logger(){
    var log = Logger(
        printer: PrettyPrinter(
            printEmojis: false,
            colors: false,
        )
    );

    try {
      log.d("debug message");
      log.i("info message");
      throw StateError("state error");
    }
    catch(e){
      log.w("error ",error: e);
    }
  }

  void sample4Logger(){
    Logger.level = Level.debug;
    var log = Logger(
        printer: PrettyPrinter(
            printEmojis: false,
            colors: false,
            methodCount: 0,
            noBoxingByDefault : true, // 枠を表示しない,
        )
    );

    try {
      log.d("debug message");
      log.i("info message");
      throw StateError("state error");
    }
    catch(e){
      log.w("error ",error: e);
    }
  }

  void sample5Logger(){
    var log = Logger(
        printer: CustomPrinter(),
    );

    try {
      log.d("debug message");
      log.i("info message");
      throw StateError("state error");
    }
    catch(e){
      log.w("error ",error: e);
    }
  }

  void sample6Logger(){
    var log = Logger(
      printer: CustomPrinter(),
      output: CustomLogOutput()
    );

    try {
      log.d("debug message");
      log.i("info message");
      throw StateError("state error");
    }
    catch(e){
      log.w("error ",error: e);
    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
          title : const Text("サンプル(1)")
      ),
      body: Container(
      )
    );
  }
}

class SampleOneScreen extends StatefulWidget{
  const SampleOneScreen({super.key, required String title});

  @override
  State createState() {
    return _SampleOneScreen();
  }
}

class CustomPrinter extends LogPrinter{
  @override
  List<String> log(LogEvent event) {
    var buf = StringBuffer();
    buf.write("${event.level} - ${event.time.hour}:${event.time.minute}:${event.time.second} - ${event.message}");
    if(event.error != null){
      buf.write("error - ${event.error}");
      if(event.stackTrace == null){
        if(event.error is Error){
          Error err = event.error as Error;
          buf.write("stacktrace - ${err.stackTrace}");
        }
      }
    }
    if(event.stackTrace != null){
      buf.write("stacktrace - ${event.stackTrace}");
    }
    return [buf.toString()];
  }
}

class CustomLogOutput extends LogOutput{
  @override
  void output(OutputEvent event) {
    var client = http.Client();
    var f = client.post(
        Uri.http('192.168.1.1', 'flutter/log'),
        body: {'time': "${event.origin.time}", 'level' : "${event.level}", 'message' : event.lines.join(",") });
    f.then((res){
      if (kDebugMode) {
        print(res.body);
      }
    });
  }
}