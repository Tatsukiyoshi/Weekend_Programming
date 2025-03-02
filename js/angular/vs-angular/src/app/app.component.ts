import { Component, AfterViewInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    imports: [RouterOutlet]
})
export class AppComponent implements AfterViewInit {
  ngAfterViewInit(): void {
    throw new Error("Method not implemented.");
  }
  title = 'vs-angular';
}
