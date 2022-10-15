import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BookService } from './book.service';
import { Hoge } from './hoge';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    { provide: Hoge, useClass: BookService }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
