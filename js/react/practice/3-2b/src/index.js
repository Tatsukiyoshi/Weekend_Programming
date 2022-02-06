// buttonタグの生成
const buttonEl = document.createElement("button");

// ボタンへのラベル設定
buttonEl.textContent = "ボタン";

// エリア１のdivタグを取得
const div1El = document.querySelector(".container");

// divタグ配下にbuttonタグを追加
div1El.appendChild(buttonEl);
