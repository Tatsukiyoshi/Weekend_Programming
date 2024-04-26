import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:vol22/data/Response.dart';

class ApiClient extends http.BaseClient{
  final String apiKey;
  final String baseUrl;
  final http.Client _client;

  ApiClient(this.apiKey,this.baseUrl,this._client);

  @override
  Future<http.StreamedResponse> send(http.BaseRequest request) {
    request.headers['Content-Type'] = 'application/json';
    request.headers['X-Chat-App-Key'] = apiKey;
    return _client.send(request);
  }

  /*
   *  初期設定の取得
   */
  Future<bool> config() async{
    var url = Uri.parse("$baseUrl/login/config.php");
    var res = get(url);
    var response = await _parseResponse(res);
    if(response.ok){
      return Future.value(true);
    }
    else{
      return Future.value(false);
    }
  }

  /*
   *  ログイン処理
   */
  Future<Response> login(String loginId, String password){
    var body = {
      'login_id' : loginId,
      'password' : password
    };
    var url = Uri.parse("$baseUrl/login/json.php");
    var res = post(url,body : json.encode(body));
    return _parseResponse(res);
  }

  Future<Response> _parseResponse(Future<http.Response> response){
    var c = Completer<Response>();
    response.then((value){
      if(value.statusCode == 200){
        var json = jsonDecode(utf8.decode(value.bodyBytes)) as Map<String,dynamic>;
        if(json['ok']){
          c.complete(Future.value(Response.ok(json['code'], json['message'],json['body'])));
        }
        else{
          c.complete(Response.error(json['code'], json['message']));
        }
      }
      else{
        c.complete(Response.error(value.statusCode, value.body));
      }
    });
    return c.future;
  }
}
