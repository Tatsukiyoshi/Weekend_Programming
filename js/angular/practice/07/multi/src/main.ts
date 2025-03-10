import { enableProdMode, importProvidersFrom } from '@angular/core';

import { environment } from './environments/environment';
import { KEYWORDS } from './app/app-info';
import { BrowserModule, bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';

if (environment.production) {
  enableProdMode();
}

bootstrapApplication(AppComponent, {
    providers: [
        importProvidersFrom(BrowserModule),
        { provide: KEYWORDS, useValue: 'TypeScript', multi: true },
        { provide: KEYWORDS, useValue: 'Angular', multi: true }
    ]
})
  .catch(err => console.error(err));
