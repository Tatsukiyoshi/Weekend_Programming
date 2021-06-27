package com.nativemodulestest;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeviceInformationPackage implements ReactPackage {
    // テンプレート的な実装。単に作成したDeviceInformationModule new して modules に追加
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new DeviceInformationModule(reactContext));
        return modules;
    }

    // View を使わない場合は、emptyList を返す
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
