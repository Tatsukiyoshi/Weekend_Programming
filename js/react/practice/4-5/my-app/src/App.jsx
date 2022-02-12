import { ColoredMessage } from "./components/ColoredMessage";

export const App = () => {
    // ボタンを押したときに実行する関数を定義
    const onClickButton = () => {
        alert();
    };

    return (
        <>
            {console.log("TEST")}
            <h1 style={{ color: "red" }}>こんにちは！</h1>
            <ColoredMessage color="blue">お元気ですか？</ColoredMessage>
            <ColoredMessage color="pink">元気です！</ColoredMessage>
            <button onClick={onClickButton}>ボタン</button>
        </>
    );
};

