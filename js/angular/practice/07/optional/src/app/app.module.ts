import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ChildComponent } from './child.component';
import { NoParentComponent } from './no-parent.component';
import { ParentComponent } from './parent.component';

@NgModule({
  declarations: [
    AppComponent, ParentComponent, ChildComponent, NoParentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
