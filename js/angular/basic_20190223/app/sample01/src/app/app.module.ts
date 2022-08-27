import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { Child01Component } from './child01/child01.component';
import { Child02Component } from './child02/child02.component';

@NgModule({
  declarations: [
    AppComponent,
    Child01Component,
    Child02Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
