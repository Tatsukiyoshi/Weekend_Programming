import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { TrimPipe } from './trim.pipe';

@Component({
  imports: [TrimPipe],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pipe';
  msg = '   WINGS Project   ';
}
