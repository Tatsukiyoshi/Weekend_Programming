import 'package:vol22/client/ApiClient.dart';
import 'package:vol22/controller/ILoginController.dart';
import 'package:vol22/data/Response.dart';
import 'package:http/http.dart' as http;

class ClientLoginController extends ILoginController{
  String apiKey;
  String baseUrl;

  ClientLoginController(this.apiKey,this.baseUrl);

  @override
  Future<bool> config() {
    var client = http.Client();
    try{
      var api = ApiClient(apiKey, baseUrl,client);
      return api.config();
    }
    finally{
      client.close();
    }
  }

  @override
  Future<Response> login(String loginId, String password){
    var client = http.Client();
    try{
      var api = ApiClient(apiKey, baseUrl, client);
      return api.login(loginId, password);
    }
    finally{
      client.close();
    }
  }
}
