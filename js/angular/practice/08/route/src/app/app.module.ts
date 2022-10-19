import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './main.component';
import { ExampleComponent } from './example.component';
import { ErrorComponent } from './error.component';
import { ContentComponent } from './content.component';

@NgModule({
  declarations: [
    AppComponent, MainComponent, ExampleComponent, ErrorComponent, ContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
