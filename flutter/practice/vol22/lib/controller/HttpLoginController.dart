import 'dart:convert';
import 'package:vol22/controller/ILoginController.dart';
import 'package:vol22/data/Response.dart';
import 'package:http/http.dart' as http;

class HttpLoginController extends ILoginController{
  Map<String,dynamic> _config = {};

  @override
  Future<bool> config() async{
    var url = Uri.parse("http://192.168.100.20/config.php");

    var response = await http.get(url);
    if(response.statusCode == 200){
      //  (1) 日本語が文字化けしてしまう
      _config = jsonDecode(response.body) as Map<String,dynamic>;
      //  (2) 日本語が含まれている場合
      _config = jsonDecode(utf8.decode(response.bodyBytes)) as Map<String,dynamic>;
      return Future.value(true);
    }
    else{
      return Future.value(false);
    }
  }

  @override
  Future<Response> login(String loginId, String password) async {
    return loginJson(loginId, password);
  }

  Future<Response> loginForm(String loginId, String password) async {
    var url = Uri.parse("http://192.168.100.20/login/form.php");

    var response = await http.post(url, body : {
      'login_id' : loginId,
      'password' : password
    },headers: {
      'X-Chat-App-Key' : 'api_key'
    });
    if(response.statusCode == 200){
      var json = jsonDecode(utf8.decode(response.bodyBytes)) as Map<String,dynamic>;
      if(json['ok']){
        return Future.value(Response.ok(json['code'], json['message'],json['body']));
      }
      else{
        return Future.value(Response.error(json['code'], json['message']));
      }
    }
    else {
      return Future.value(Response.error(response.statusCode, response.body));
    }
  }

  Future<Response> loginJson(String loginId, String password) async{
    var url = Uri.parse("http://192.168.100.20/login/json.php");
    var headers = {
      'Content-Type': 'application/json',
      'X-Chat-App-Key' : 'api_key'
    };
    var body = {
      'login_id' : loginId,
      'password' : password
    };
    
    var response = await http.post(url, body : jsonEncode(body),headers: headers);
    if(response.statusCode == 200){
      var json = jsonDecode(utf8.decode(response.bodyBytes)) as Map<String,dynamic>;
      if(json['ok']){
        return Future.value(Response.ok(json['code'], json['message'],json['body']));
      } else{
        return Future.value(Response.error(json['code'], json['message']));
      }
    } else {
      return Future.value(Response.error(response.statusCode, response.body));
    }
  }
}
