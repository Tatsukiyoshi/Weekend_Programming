import 'package:vol21/data/Response.dart';

abstract class ILoginController{

  Future<bool> config();

  Future<Response> login(String loginId,String password);

  void dispose(){

  }
}
