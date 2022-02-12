import { useState } from "react";
import { ColoredMessage } from "./components/ColoredMessage";

// 5-2 CSS Modules
import { CssModules } from "./components/CssModules";
// 5-3 Styled JSX
import { StyledJsx} from "./components/StyledJsx";
// 5-4 Styled Components
import { StyledComponents } from "./components/StyledComponents";
// 5-5 Emotion
import { Emotion } from "./components/Emotion";
import { TailwindCss } from "./components/TailwindCss";

export const App = () => {
    // Stateの定義
    const [num, setNum] = useState(0);

    // ボタンを押した時にStateをカウントアップ
    const onClickButton = () => {
        setNum(num + 1);
    };

    return (
        <>
            {console.log("TEST")}
            <h1 style={{ color: "red" }}>こんにちは！</h1>
            <ColoredMessage color="blue">お元気ですか？</ColoredMessage>
            <ColoredMessage color="pink">元気です！</ColoredMessage>
            <button onClick={onClickButton}>ボタン</button>
            <p>{num}</p>

            <CssModules />

            <StyledJsx />

            <StyledComponents />

            <Emotion />

            <TailwindCss />
        </>
    );
};
