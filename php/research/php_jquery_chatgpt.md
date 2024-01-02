# PHPとjQueryを使用したグラフ表示のサンプルプログラム

## 1. 環境構築

### 1.1 ウェブサーバーのセットアップ
- ローカルで実行する場合、XAMPPやMAMPなどのパッケージを使用するか、独自にウェブサーバーをセットアップします。

### 1.2 ファイル配置
- プログラムのファイルをウェブサーバーのドキュメントルートに配置します。
- 例:
    -   web-root
        -   your-project-folder
            -   index.html
            -   getData.php

## 2. プログラム作成

### 2.1 HTMLファイル (index.html)
```html
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PHPとjQueryでグラフを表示</title>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <script type="text/javascript">
      // ...（前回のコードをここに貼り付け）
  </script>
</head>
<body>
  <div id="chart_div" style="width: 100%; height: 400px;"></div>
</body>
</html>
```

### 2.2 PHPファイル (getData.php)

```php
<?php
$data = array(
    array('日付', '値'),
    array('2023-01-01', 50),
    array('2023-01-02', 80),
    array('2023-01-03', 60),
    array('2023-01-04', 90),
    // 追加したデータはここに記述
);

header('Content-Type: application/json');
echo json_encode($data);
?>
```

##  3. プログラム実行
ウェブサーバーを起動します。
ブラウザで http://localhost/your-project-folder/index.html にアクセスします。
グラフが正しく表示され、サンプルデータが表示されることを確認します。

##  4. データの追加
getData.php ファイルに新しいデータを追加します。
ブラウザで表示しているページをリロードして、新しいデータがグラフに反映されることを確認します。

このMarkdownをコピーして、手順に従って進めてみてください。
