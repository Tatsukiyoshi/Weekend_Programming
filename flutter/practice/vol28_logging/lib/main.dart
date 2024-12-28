import 'package:flutter/foundation.dart';
import 'package:logging/logging.dart';
import 'package:http/http.dart' as http;

void main(){
  sample4();
  sample1();
}

void sample1(){
  Logger.root.level = Level.ALL;
  Logger.root.onRecord.listen((LogRecord event) {
    if (kDebugMode) {
      print("${event.time} - ${event.loggerName}(${event.level.name}) - ${event.message}");
    }
  });

  var log = Logger("sample-one");
  log.info("widget initState()");
}


void sample2(){
  var log = Logger("level-sample");
  Logger.root.level = Level.CONFIG;

  log.fine("fine message");
  log.config("config message");
  log.info("info message");
  log.warning("warn message");

  if(log.isLoggable(Level.FINE)){
    log.fine("fine message");
  }
}

void sample3(){
  Logger.root.onRecord.listen((LogRecord event){
    if (kDebugMode) {
      print("${event.sequenceNumber} - time : ${event.time}");
      print("${event.sequenceNumber} - loggerName : ${event.loggerName}");
      print("${event.sequenceNumber} - level : ${event.level}");
      print("${event.sequenceNumber} - message : ${event.message}");
    }

    if(event.error != null){
      if (kDebugMode) {
        print("${event.sequenceNumber} - error - (${event.error.runtimeType}) - [${event.error.toString()}]");
      }
    }
    if(event.stackTrace != null){
      if (kDebugMode) {
        print(event.stackTrace);
      }
    }
  });
}

void sample4(){
  var client = http.Client();
  Logger.root.onRecord.listen((LogRecord event){
    var f = client.post(
      Uri.http('192.168.1.1', 'flutter/log'),
      body: {'time': "${event.time}", 'name': event.loggerName, 'level' : "${event.level}", 'message' : event.message });
    f.then((res){
      if (kDebugMode) {
        print(res.body);
      }
    });
  });
}
