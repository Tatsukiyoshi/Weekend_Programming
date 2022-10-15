import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { APP_INFO, MY_APP_INFO } from './app-info';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    { provide: APP_INFO, useValue: MY_APP_INFO }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
