import 'package:flutter/foundation.dart';
import 'package:vol22/controller/ILoginController.dart';
import 'package:vol22/data/Response.dart';

// 実際にはリクエストせずに非同期処理をダミーで行う
class MockLoginController extends ILoginController{

  @override
  Future<bool> config() {
    return Future.delayed(const Duration(seconds: 3),(){
      return true;
    });
  }

  @override
  Future<Response> login(String loginId, String password) {
    return loginFalseWithDuration(loginId, password);
  }

  Future<Response> loginFalse(String loginId,String password){
    return Future.value(Response.error(500, 'ログインIDまたはパスワードを確認してください'));
  }

  Future<Response> loginTrueWithDuration(String loginId,String password){
    return Future.delayed(const Duration(seconds: 1),(){
      return Response(true,200);
    });
  }

  Future<Response> loginFalseWithDuration(String loginId,String password){
    return Future.delayed(const Duration(seconds: 5),(){
      return Response.error(500, 'ログインIDまたはパスワードを確認してください');
    });
  }

  Future<Response> loginSync(String loginId,String password){
    return Future.sync((){
      if (kDebugMode) {
        print("実行中");
      }
      return Response.error(500, 'ログインIDまたはパスワードを確認して下さい');
    });
  }

  Future<Response> loginError(String loginId,String password){
    return Future.error(Error());
  }
}
