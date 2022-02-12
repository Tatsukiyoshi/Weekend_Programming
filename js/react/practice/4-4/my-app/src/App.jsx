export const App = () => {
    // ボタンを押したときに実行する関数を定義
    const onClickButton = () => {
        alert();
    };

    // CSSオブジェクト
    const contentStyle = {
        color: "blue",
        fontSize: "20px"
    };

    return (
        <>
            {console.log("TEST")}
            <h1 style={{ color: "red" }}>こんにちは！</h1>
            <p style={contentStyle}>お元気ですか？</p>
            <button onClick={onClickButton}>ボタン</button>
        </>
    );
};

