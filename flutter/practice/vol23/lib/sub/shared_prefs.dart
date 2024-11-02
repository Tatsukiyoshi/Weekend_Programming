import 'package:flutter/foundation.dart';
import 'package:shared_preferences/shared_preferences.dart';

Future<void> sharedPrefs() async{
    // (1) SharedPreferences のインスタンスを取得
    var prefs = await SharedPreferences.getInstance();

    // (2) 値の保存
    prefs.setBool("enable_save", true);
    prefs.setString("api_key", "dummy_key");
    prefs.setInt("last_at", DateTime.now().microsecondsSinceEpoch);
    prefs.setDouble("margin", 5.5);
    prefs.setStringList("keys", ["a","b","c"]);

    // (3) 値の取得
    if (kDebugMode) {
        final bool? enableSave = prefs.getBool("enable_save");
        final String? apiKey = prefs.getString("api_key");
        final int? lastAt = prefs.getInt("last_at");
        final double? margin = prefs.getDouble("margin");
        final List<String>? keys = prefs.getStringList("keys");
        print("enable_save is $enableSave");
        print("api_key is $apiKey");
        print("last_at is $lastAt");
        print("margin is $margin");
        for(var key in keys!){
            print("key is $key");
        }
    }

    // (4) 保存されているKey値の取得
    final Set<String> prefKeys = prefs.getKeys();
    for(var name in prefKeys){
      if (kDebugMode) {
        print("key is $name");
      }
    }

    // (5) 値の削除
    final bool ret = await prefs.remove("keys");

    // (6) すべての値をクリアする
    final bool ok = await prefs.clear();
}