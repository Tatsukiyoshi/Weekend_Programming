import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { CoopModule } from './coop/coop.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, CoopModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
