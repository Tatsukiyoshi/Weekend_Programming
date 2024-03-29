// File generated by FlutterFire CLI.
// ignore_for_file: lines_longer_than_80_chars, avoid_classes_with_only_static_members
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for windows - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyDCvmQZYelEXMESVUzksDscI7WqCJmkMrg',
    appId: '1:163776987535:web:247ee777d46a3683834bfa',
    messagingSenderId: '163776987535',
    projectId: 'taishow2006-firebase-overview',
    authDomain: 'taishow2006-firebase-overview.firebaseapp.com',
    storageBucket: 'taishow2006-firebase-overview.appspot.com',
    measurementId: 'G-SZQ5SDZW90',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyCKZaIYEXVVh3pyyBL23f3_LYhEuT1oBSQ',
    appId: '1:163776987535:android:a89fcfd7c79df4fb834bfa',
    messagingSenderId: '163776987535',
    projectId: 'taishow2006-firebase-overview',
    storageBucket: 'taishow2006-firebase-overview.appspot.com',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyCHYW-97kAvEEgH3FMPWa2OYu_MRkVyYD4',
    appId: '1:163776987535:ios:5324879a9c786539834bfa',
    messagingSenderId: '163776987535',
    projectId: 'taishow2006-firebase-overview',
    storageBucket: 'taishow2006-firebase-overview.appspot.com',
    iosClientId: '163776987535-e2llk0kgsq0k6biorfbgt96h6p07n5e0.apps.googleusercontent.com',
    iosBundleId: 'com.example.inAppMessaging',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyCHYW-97kAvEEgH3FMPWa2OYu_MRkVyYD4',
    appId: '1:163776987535:ios:6a2fe4ffdd4c820b834bfa',
    messagingSenderId: '163776987535',
    projectId: 'taishow2006-firebase-overview',
    storageBucket: 'taishow2006-firebase-overview.appspot.com',
    iosClientId: '163776987535-l4h5r39jcoj13oijc8ru0l3vofhdo45n.apps.googleusercontent.com',
    iosBundleId: 'com.example.inAppMessaging.RunnerTests',
  );
}
