import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {A11yModule} from "@angular/cdk/a11y";
import {BidiModule} from "@angular/cdk/bidi";
import {ObserversModule} from "@angular/cdk/observers";
import {OverlayContainer, OverlayModule} from "@angular/cdk/overlay";
import {PlatformModule} from "@angular/cdk/platform";
import {PortalModule} from "@angular/cdk/portal";
import {ScrollingModule} from "@angular/cdk/scrolling";
import {CdkStepperModule} from "@angular/cdk/stepper";
import {CdkTableModule} from "@angular/cdk/table";
import {MatAutocompleteModule} from "@angular/material/autocomplete"
import {MatBottomSheetModule} from "@angular/material/bottom-sheet"
import {MatButtonModule} from "@angular/material/button"
import {MatButtonToggleModule} from "@angular/material/button-toggle"
import {MatCardModule} from "@angular/material/card"
import {MatCheckboxModule} from "@angular/material/checkbox"
import {MatChipsModule} from "@angular/material/chips"
import {MatDatepickerModule} from "@angular/material/datepicker"
import {MatDialog, MatDialogModule} from "@angular/material/dialog"
import {MatExpansionModule} from "@angular/material/expansion"
import {MatFormFieldModule} from "@angular/material/form-field"
import {MatGridListModule} from "@angular/material/grid-list"
import {MatIconModule} from "@angular/material/icon"
import {MatInputModule} from "@angular/material/input"
import {MatListModule} from "@angular/material/list"
import {MatMenuModule} from "@angular/material/menu"
import {MatPaginatorModule} from "@angular/material/paginator"
import {MatProgressBarModule} from "@angular/material/progress-bar"
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner"
import {MatRadioModule} from "@angular/material/radio"
import {MatSelectModule} from "@angular/material/select"
import {MatSidenavModule} from "@angular/material/sidenav"
import {MatSliderModule} from "@angular/material/slider"
import {MatSlideToggleModule} from "@angular/material/slide-toggle"
import {MatSnackBarModule} from "@angular/material/snack-bar"
import {MatSortModule} from "@angular/material/sort"
import {MatStepperModule} from "@angular/material/stepper"
import {MatTableModule} from "@angular/material/table"
import {MatTabsModule} from "@angular/material/tabs"
import {MatToolbarModule} from "@angular/material/toolbar"
import {MatTooltipModule} from "@angular/material/tooltip"
import {
  MatNativeDateModule,
  MatRippleModule,
} from "@angular/material/core";
import {MatDividerModule} from '@angular/material/divider';
import {HttpClientJsonpModule, HttpClientModule} from "@angular/common/http";
import {RootComponent} from "./component/root/root.component";
import {ListComponent} from "./component/list/list.component";
import {RouterModule, Routes} from "@angular/router";
import {appRoutes} from "./app.route";
// import {RemoteDbService} from "./service/remoteDb.service";
import {SearchComponent} from "./component/search/search.component";
import {DataService} from "./service/data.service";
import {DetailDialogComponent} from "./component/detail/detail.dialog";
import {ScrollService} from "./service/scroll.service";
import {environment} from "../environments/environment";
import {ServiceWorkerModule} from "@angular/service-worker";
import {DbService} from "./service/db.service";
import {StateService} from "./service/state.service";
import { FavoriteComponent } from './component/favorite/favorite.component';
import { SettingComponent } from './component/setting/setting.component';

/**
 * NgModule that includes all Material modules that are required to serve the app.
 *
 */
@NgModule({
  exports: [
    // CDK
    A11yModule,
    BidiModule,
    ObserversModule,
    OverlayModule,
    PlatformModule,
    PortalModule,
    ScrollingModule,
    CdkStepperModule,
    CdkTableModule,

    // Material
    MatAutocompleteModule,
    MatButtonModule,
    MatBottomSheetModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule
  ],
  declarations: [],
  imports: [BrowserAnimationsModule],
})
export class MaterialModule {
}

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientJsonpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ServiceWorkerModule.register("/ngsw-worker.js", {enabled: environment.production}),
  ],
  // entryComponents deprecated from Angular 9
  //entryComponents: [DetailDialogComponent,SettingComponent],
  declarations: [FavoriteComponent,DetailDialogComponent, ListComponent, RootComponent, ListComponent, SearchComponent,SettingComponent],
  bootstrap: [RootComponent],
  providers: [DataService, ScrollService, DbService, StateService]
})
export class AppModule {
}
