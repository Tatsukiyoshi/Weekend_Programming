// divタグの生成
const divEl = document.createElement("div");

// pタグの生成
const pEl = document.createElement("p");

// h2タグの生成
const h2El = document.createElement("h2");

// divタグ配下にPタグを追加
divEl.appendChild(pEl);

// divタグ配下にh2タグを追加
divEl.appendChild(h2El);

console.log(divEl);
