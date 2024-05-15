import 'package:flutter/foundation.dart';
//import 'package:vol22/controller/ClientLoginController.dart';
import 'package:vol22/controller/HttpLoginController.dart';
import 'package:vol22/controller/ILoginController.dart';
//import 'package:vol22/controller/MockLoginController.dart';
import 'package:vol22/data/Response.dart';
import 'package:vol22/page/WelcomePage.dart';
import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget{
  const LoginPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return _LoginPage();
  }
}

class _LoginPage extends State<LoginPage>{

  // ログインフォームとID、パスワードの入力コントローラー
  final _formState = GlobalKey<FormState>();
  final _loginIdController = TextEditingController();
  final _passwdController = TextEditingController();

  final _loginIdFocus = FocusNode();
  final _passwdFocus = FocusNode();

  //  (1) このページの処理をする為のクラス
  final ILoginController _pageController = HttpLoginController(); // ClientLoginController("api_key","http://192.168.100.20");

  //  (2) 初期データ読みこみ完了フラグ
  var _init = false;

  //  (3) ログインリクエストの読み込み中フラグ
  var _loading = false;

  @override
  Widget build(BuildContext context) {
    if (kDebugMode) {
      print("build");
    }
    return Scaffold(
      body: Stack(
        children: [
          Form(
              key: _formState,
              child: Container(
                padding: const EdgeInsets.all(20.0),
                child: createLoginForm(context),
              )
          ),
          // (4) 読込中の場合には、画面の上にローディング画面を表示
          if(!_init) createLoadingGlass(context),
          if(_loading) createLoadingGlass(context),
        ],
      )
    );
  }

  @override
  void initState(){
    // (5) 初期データを読みこむ
    var f = _pageController.config();
    f.then((value) => setState((){
      _init = true;
    }));
    f.catchError((error){

    });
    super.initState();
  }

  @override
  void dispose() {
    _loginIdController.dispose();
    _passwdController.dispose();

    _pageController.dispose();
    super.dispose();
  }

  // (6) ローディング画面を作成する
  Widget createLoadingGlass(BuildContext context){
    return Container(
        color: Colors.black38,
        width: double.infinity,
        height: double.infinity,
        child: const Center(
          child: CircularProgressIndicator()
        )
    );
  }

  String? fieldValidator(String? value){
    if(value == null || value.isEmpty){
      return '入力必須です';
    }
    return null;
  }

  Widget createLoginForm(BuildContext context){
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        TextFormField(
          focusNode: _loginIdFocus,
          validator: fieldValidator,
          controller: _loginIdController,
          decoration: const InputDecoration(
            labelText: 'ログインID',
          ),
        ),
        TextFormField(
          focusNode: _passwdFocus,
          validator: fieldValidator,
          obscureText: true,
          controller: _passwdController,
          decoration: const InputDecoration(
            labelText: 'パスワード',
          ),
        ),
        ElevatedButton(
            onPressed: () async {
          final ok = _formState.currentState!.validate();
          if(ok){
            ScaffoldMessenger.of(context).hideCurrentSnackBar();

            // フォーカスを外す（キーボードを閉じる）
            _loginIdFocus.unfocus();
            _passwdFocus.unfocus();

            setState(() {
              _loading = true;
            });

            //  (7) サーバ側にリクエストする
            try {
              Response res = await _pageController.login(
                  _loginIdController.text, _passwdController.text);

              if (res.ok) {
                if (kDebugMode) {
                  print(res.message);
                }

                // ログイン成功
                Navigator.of(context).pushReplacement(MaterialPageRoute(
                  builder: (context) {
                    return WelcomePage();
                  }
                ));
              } else {
                showErrorSnackBar(context, res.message);
              }
            } on Error catch(e){
              if (kDebugMode) {
                print(e.toString());
              }
              showErrorSnackBar(context, '不明なエラーが発生しました');
            } finally{
              setState(() {
                _loading = false;
              });
            }
          }
        }, child: const Text('ログイン'))
      ],
    );
  }

  /*
   * エラーメッセージを表示する
   */
  void showErrorSnackBar(BuildContext context,String message){
    final bar = SnackBar(
      backgroundColor: Colors.red,
      behavior: SnackBarBehavior.floating,
        content: Text(message)
    );
    ScaffoldMessenger.of(context).showSnackBar(bar);
  }
}