import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ExampleComponent } from './example.component';
import { MainComponent } from './main.component';
import { ArticleComponent } from './article.component';

const routes: Routes = [
  { path: 'exam', component: ExampleComponent },
  { path: '', component: MainComponent},
  { path: 'article/:id', component: ArticleComponent },
  { path: '**', redirectTo: '/' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
