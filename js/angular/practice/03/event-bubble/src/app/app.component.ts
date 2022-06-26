import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'event-bubble';

  // <div id="outer">をクリックした時
  onclick1(e: any){
    console.log('outerをくりっくしました！');
  }

  // <div id="inner">をクリックした時
  onclick2(e: any){
    e.stopPropagation();  // バブリングを止める
    console.log('innerをくりっくしました！');
  }
}
