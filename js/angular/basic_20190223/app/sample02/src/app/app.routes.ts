//(1)パッケージのインポート
import {Page01Component} from "./page01.component";
import {Page02Component} from "./page02.component";

//(2)ルートマップの定義
export const ROUTES = [
  {path: "page02", component: Page02Component},
  {path: "page01", component: Page01Component},
  {path: "**", component: Page01Component}
];
