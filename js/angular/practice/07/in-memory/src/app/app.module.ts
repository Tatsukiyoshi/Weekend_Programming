import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { InMemoryWebApiModule } from "angular-in-memory-web-api";

import { AppComponent } from './app.component';
import { BooksData } from './books-data';

@NgModule({ declarations: [
        AppComponent
    ],
    bootstrap: [AppComponent], imports: [BrowserModule,
        InMemoryWebApiModule.forRoot(BooksData)], providers: [provideHttpClient(withInterceptorsFromDi())] })
export class AppModule { }
