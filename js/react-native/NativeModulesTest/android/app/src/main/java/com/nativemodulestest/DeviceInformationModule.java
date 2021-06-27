package com.nativemodulestest;

// 次のimportを追加
import android.os.Build;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

// ReactContextBaseJavaModule を継承する
public class DeviceInformationModule extends ReactContextBaseJavaModule{

    // コンストラクタの定義。super(reactContext)するだけでよい。
    public DeviceInformationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    // getName() を override.この関数の返り値が、JavaScript に公開されるModule名になる。iOSとそろえる。
    @Override
    public String getName() {
        return "DeviceInformation";
    }
    // @ReactMethod というアノテーションを行うことで、JavaScript側に定義したメソッドを公開すること示す。
    @ReactMethod
    public void getOSInfo(Callback callback) {
        // Androidでは、JavaScriptへの返り値を 可変長引数で渡す。
        callback.invoke("android",Build.VERSION.RELEASE);
    }
}
