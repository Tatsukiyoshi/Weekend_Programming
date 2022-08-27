import {Routes} from "@angular/router";
import {ListComponent} from "./component/list/list.component";
import {SearchComponent} from "./component/search/search.component";
import {FavoriteComponent} from "./component/favorite/favorite.component";
// import {AppComponent} from "./component/app.component";

export const appRoutes: Routes = [
    {path: 'search', component: SearchComponent},
    {path: 'list', component: ListComponent},
    {path: 'favorite', component: FavoriteComponent},
    {path: '', component: SearchComponent},
    // {path: "**", component: SearchComponent}
];
