//====================
// ルータ定義
//====================

import {Routes} from "@angular/router";
import {ListComponent} from "./component/list/list.component";
import {EditComponent} from "./component/edit/edit.component";
import {SetComponent} from "./component/set/set.component";

//urlパスと表示するコンポーネントの関連づけ
export const AppRoutes: Routes = [
  {path: "list", component: ListComponent},
  {path: "edit", component: EditComponent},
  {path: "set", component: SetComponent},
  {path: "", component: ListComponent}
];
