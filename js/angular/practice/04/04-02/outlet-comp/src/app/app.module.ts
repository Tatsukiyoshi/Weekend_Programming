import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BookComponent } from './book.component';
import { EventComponent } from './event.component';
import { WingsComponent } from './wings.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent, EventComponent, WingsComponent
  ],
  imports: [
    BrowserModule
  ],
  // entryComponents deprecated from Angular 9
  //entryComponents: [
  // BookComponent, EventComponent, WingsComponent
  //],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
