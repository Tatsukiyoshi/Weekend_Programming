import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { KEYWORDS } from './app-info';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    { provide: KEYWORDS, useValue: 'TypeScript' },
    { provide: KEYWORDS, useValue: 'Angular'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
