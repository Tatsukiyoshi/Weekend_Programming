import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<table border='1'>
    <tr><td [attr.rowspan]="len">結合</td><td>1</td></tr>
    <tr><td>2</td></tr>
    <tr><td>3</td></tr>
  </table>`
})
export class AppComponent {
  title = 'attr';
  len = 3;
}
