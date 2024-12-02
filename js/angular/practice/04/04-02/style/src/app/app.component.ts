import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'style';
  // スタイル情報を準備
  style = {
    backgroundColor: '#f00',
    color: '#fff',
    fontWeight: 'bold',
    margin: '15px',
    padding: '15px'
  };
}
