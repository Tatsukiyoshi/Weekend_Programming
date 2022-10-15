import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { InMemoryWebApiModule } from "angular-in-memory-web-api";

import { AppComponent } from './app.component';
import { BooksData } from './books-data';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    InMemoryWebApiModule.forRoot(BooksData)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
