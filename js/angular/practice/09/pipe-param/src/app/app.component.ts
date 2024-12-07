import { Component } from '@angular/core';
import { TruncatePipe } from './truncate.pipe';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule, TruncatePipe],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pipe-param';
  memo: string = "";
}
