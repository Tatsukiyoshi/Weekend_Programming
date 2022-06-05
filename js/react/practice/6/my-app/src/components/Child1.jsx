import { React } from "react";
import { memo } from "react";
import { Child2 } from "./Child2";
import { Child3 } from "./Child3";

const style = {
    height: "200px",
    backgroundColor: "lightblue",
    padding: "8px"
};

export const Child1 = memo((props) => {
    console.log("Child1レンダリング");

    // propsから関数を展開（分割代入）
    const { onClickReset } = props;

    return (
        <div style={style}>
            <p>Child1</p>
            {/* 渡された関数を実行するボタンを設置 */}
            <button onClick={onClickReset}>リセット</button>
            <Child2 />
            <Child3 />
        </div>
    );
});
