// 各変数を定義
let classifier;
let video;
let label = "";

// リスト４（初期化部分）
function setup() {
	createCanvas(640, 480);
	video = createCapture(VIDEO);
	video.hide();
	classifier = ml5.imageClassifier("MobileNet", video, modelLoaded);
}

// リスト１０（推測結果を表示）
function draw() {
	image(video, 0, 0);
	fill(255);
	textSize(32);
	text(label, 10, height - 10);
}

// リスト６（学習モデルを読み込み終わったら推測開始）
function modelLoaded() {
	console.log("Model Loaded!");
	classifier.predict(gotResults);
}

// リスト１１（推測結果を表示し続ける）
function gotResults(err, results) {
	if(err) {
		console.error(err);
	} else {
		console.log(results);
		label = results[0].className;
		classifier.predict(gotResults);
	}
}