import { useState } from "react";
import { Card } from "./components/Card";

export const App = () => {
  // 管理者フラグ
  const [isAdmin, setIsAdmin] = useState(false);

  // [切り替え]押下時
  const onClickSwitch = () => setIsAdmin(!isAdmin);

  return (
    <div>
      {/* 管理者フラグがtrueの時とそれ以外で文字を出し分け */}
      {isAdmin ? <span>管理者です</span> : <span>管理者以外です</span>}
      <button onClick={onClickSwitch}>切り替え</button>
      <Card isAdmin={isAdmin} />
    </div>
  );
};
