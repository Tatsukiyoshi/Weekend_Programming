import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'event-prevent';

  mask(e: any){
    let k = e.which;

    // 決められたキーコード以外はイベント本来の動作をキャンセル
    if(!((k >= 48 && k <=57) || k === 45 || k === 8 || k === 0)){
      e.preventDefault();
    }
  }
}
