import { Component, OnInit } from '@angular/core';
import { Child02Component } from '../child02/child02.component';

@Component({
  selector: 'app-child01',
  templateUrl: './child01.component.html',
  styleUrls: ['./child01.component.css']
})
export class Child01Component implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
