import { Component } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  safeUrl: SafeResourceUrl;
  url = `https://www.wings.msn.to/`;

  constructor(private sanitizer: DomSanitizer) {
    this.safeUrl = sanitizer.bypassSecurityTrustHtml(this.url);
  }
}
