// 名前の初期設定 ...（1）
(document.getElementById('name-input') as HTMLInputElement).value = // ...（1a）
    document.getElementById('name-disp')!.textContent = '吉川英一' // ...（1b）

    // テキストボックス変更時の処理 ...（2）
document.getElementById('name-input')!.addEventListener('input', function () {
    // テキストボックスの文字列を取得 ...（2a）
    const inputValue = (document.getElementById('name-input') as HTMLInputElement).value
    
    // 文字列をラベルに設定 ...（2b）
    document.getElementById('name-disp')!.textContent = inputValue
})
// ボタンクリック時の処理 ...（3）
document.getElementById('greet-btn')!.addEventListener('click', function () {
    // テキストボックスの文字列を取得 ...（3a）
    const inputValue = (document.getElementById('name-input') as HTMLInputElement).value

    // MyFirstTSクラスを利用してあいさつ文を作ってダイアログ表示 ...（3b）
    const myFirstTS = new MyFirstTS(inputValue)
    alert(myFirstTS.getGreetText())
})
