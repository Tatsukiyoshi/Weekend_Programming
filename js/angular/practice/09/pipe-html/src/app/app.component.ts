import { Component } from '@angular/core';
import { Nl2brPipe } from './nl2br.pipe';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule, Nl2brPipe],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pipe-html';
  memo: any;
}
