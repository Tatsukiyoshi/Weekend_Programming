import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ExampleComponent } from './example.component';
import { MainComponent } from './main.component';
import { ArticleComponent } from './article.component';
import { ParamComponent } from './param.component';
import { DataComponent } from './data.component';
import { SearchComponent } from './search.component';

const routes: Routes = [
  { path: 'exam', component: ExampleComponent },
  { path: 'main', component: MainComponent},
  { path: 'article/:id', component: ArticleComponent },
  { path: 'param', component: ParamComponent },
  { path: 'data', component: DataComponent,
    data: { category: 'Angular'}},
  { path: 'search/:id', component: SearchComponent,
    outlet: 'other' },
  { path: '', redirectTo: '/main(other:search/Angular)',
    pathMatch: 'full' },
  { path: '**', redirectTo: '/' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
