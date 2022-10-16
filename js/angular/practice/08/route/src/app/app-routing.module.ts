import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ExampleComponent } from './example.component';
import { MainComponent } from './main.component';

const routes: Routes = [
  { path: 'exam', component: ExampleComponent },
  { path: '', component: MainComponent},
  { path: '**', redirectTo: '/' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
