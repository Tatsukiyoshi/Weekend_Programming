import { Component } from '@angular/core';
import { GrepPipe } from './grep.pipe';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule, GrepPipe],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pipe-array';
  data = [ 'あいうえお', 'かきくけ', 'さしす', 'たちつてと', 'な' ];

  myFilter(value: string){
    return String(value).length < 5;
  }
}
