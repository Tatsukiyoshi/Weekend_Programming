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
import {
  MatAutocompleteModule, MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule, MatDialog,
  MatDialogModule,
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
} from "@angular/material";
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
  entryComponents: [DetailDialogComponent,SettingComponent],
  declarations: [FavoriteComponent,DetailDialogComponent, ListComponent, RootComponent, ListComponent, SearchComponent,SettingComponent],
  bootstrap: [RootComponent],
  providers: [DataService, ScrollService, DbService, StateService]
})
export class AppModule {
}
