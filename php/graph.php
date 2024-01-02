<?php
// PostgreSQLに接続する
$dbh = new PDO('pgsql:dbname=batch host=localhost port=5432', 'spring', 'password');
// データベースからデータを取得する
$sql = 'SELECT * FROM chart';
$stmt = $dbh->query($sql);
$data = $stmt->fetchAll(PDO::FETCH_ASSOC);
// データをJSON形式に変換する
$json = json_encode($data);
// データベースとの接続を切断する
$dbh = null;
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>PHPとjQueryでグラフを表示する</title>
  <!-- jQueryとChart.jsを読み込む -->
  <!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
  <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script> -->
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.umd.js"></script>
</head>
<body>
  <!-- グラフを表示するためのcanvas要素 -->
  <canvas id="myChart" width="400" height="200"></canvas>
  <script>
    // PHPから受け取ったJSONデータを変数に格納する
    var data = <?php echo $json; ?>;
    // ラベルと値の配列を作成する
    var labels = [];
    var values = [];
    for (var i = 0; i < data.length; i++) {
      labels.push(data[i].label);
      values.push(data[i].value);
    }
    // グラフのオプションを設定する
    var options = {
      type: 'line', // グラフの種類（line, bar, pieなど）
      data: {
        labels: labels, // ラベルの配列
        datasets: [{
          label: 'データ', // データセットのラベル
          data: values, // 値の配列
          backgroundColor: 'rgba(255, 99, 132, 0.2)', // 背景色
          borderColor: 'rgba(255, 99, 132, 1)', // 境界線の色
          borderWidth: 1 // 境界線の太さ
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true // y軸の最小値を0にする
          }
        }
      }
    };
    // canvas要素を取得する
    var ctx = document.getElementById('myChart').getContext('2d');
    // グラフを描画する
    var myChart = new Chart(ctx, options);
  </script>
</body>
</html>
