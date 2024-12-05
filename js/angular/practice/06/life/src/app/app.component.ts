import { CommonModule } from '@angular/common';
import { Component, OnChanges, OnInit, DoCheck,
  AfterContentInit, AfterContentChecked,
  AfterViewInit, AfterViewChecked, OnDestroy, SimpleChanges } from '@angular/core';
import { ChildComponent } from './child.component';

@Component({
  imports: [CommonModule, ChildComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnChanges,
  OnInit, DoCheck, AfterContentInit, AfterContentChecked,
  AfterViewInit, AfterViewChecked, OnDestroy
{
  title = 'life';
  show = true;
  current = new Date();

  // チェックボックス変更時に実行
  onchange(){
    this.show = !this.show;
    this.current = new Date();
  }

  constructor(){
    console.log('constructor');
  }

  // ライフサイクルメソッド（それぞれのタイミングでログを表示）
  ngOnInit(): void {
      console.log('ngOnInit');
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges');
  }
      
  ngDoCheck(): void {
    console.log('ngDoCheck');      
  }

  ngAfterContentInit(): void {
      console.log('ngAfterContentInit');
  }

  ngAfterContentChecked(): void {
      console.log('ngAfterContentInit');
  }

  ngAfterViewInit(): void {
      console.log('ngAfterViewInit');
  }

  ngAfterViewChecked(): void {
      console.log('ngAfterViewChecked');
  }

  ngOnDestroy(): void {
      console.log('ngOnDestroy');
  }
}
