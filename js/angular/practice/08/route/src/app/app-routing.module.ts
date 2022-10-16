import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error.component';

import { ExampleComponent } from './example.component';
import { MainComponent } from './main.component';

const routes: Routes = [
  { path: 'exam', component: ExampleComponent },
  { path: '', component: MainComponent},
  { path: '**', component: ErrorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
