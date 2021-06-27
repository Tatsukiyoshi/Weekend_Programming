# Kotlinの学習
環境は、Android Studioをインストールし、同時にインストールしたkotlinを利用する

## Visual Studio Code
1. PATH環境変数にJDKおよびkotlinのパスを設定する
- E200HA
```
    - F:\ProgramData\jdk-12.0.1\bin
    - F:\Program Files\Android\Android Studio\plugins\Kotlin\kotlinc\bin
```
- E230MA
```
    - C:\Users\taish\AppData\Local\Programs\AdoptOpenJDK\bin
    - C:\Program Files\Android\Android Studio\plugins\Kotlin\kotlinc\bin
```
1. VSCodeにcode-runnerをインストールし、code-runnerにkotlinの呼び出しを記述する
    - "kotlin": "cd $dir && kotlinc-jvm.bat $fileName -include-runtime -d $fileNameWithoutExt.jar && java -jar $fileNameWithoutExt.jar"

## Android Studio
1. gradle設定は、環境変数GRADLE_USER_HOMEに設定したディレクトリに格納するよう変更

1. エミュレータのイメージは、ユーザの.androidディレクトリに格納されるため、移動する <BR>
ただし、イメージの管理ファイル(.ini)は、参照先が固定化されているようであるため、そのままとし、管理ファイル内に記載されているパスを変更 <BR>
例）path=F:\Program\.android\avd\Nexus_5X_API_28.avd
