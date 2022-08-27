//====================
// AppModule（アプリに必要なモジュール定義）クラス
//====================

//Angularモジュールのインポート
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {
  ServiceWorkerModule,
  SwPush
} from '@angular/service-worker';
import {environment} from '../environments/environment';

//Material2モジュールのインポート
import {
  MatButtonModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatSliderModule,
  MatSnackBarModule,
  MatToolbarModule
} from '@angular/material';

// 作成したコンポーネントのインポート
import {RootComponent} from './component/root/root.component';
import {ListComponent} from './component/list/list.component';
import {EditComponent} from './component/edit/edit.component';
import {SetComponent} from './component/set/set.component';

// 作成したサービスのインポート
import {DataService} from './service/data.service';
import {PermissionService} from './service/permission.service';
import {PushService} from './service/push.service';

// ルーター関連
import {RouterModule} from '@angular/router';
import {AppRoutes} from './app.route';

//アプリで使用するモジュール定義
@NgModule({
  //モジュール
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDialogModule,
    MatListModule,
    MatIconModule,
    MatToolbarModule,
    MatMenuModule,
    MatSliderModule,
    MatSnackBarModule,
    HttpClientModule,
    //ルーターの定義
    RouterModule.forRoot(AppRoutes),
    //Service Workerの登録
    ServiceWorkerModule.register(
      '/ngsw-worker.js', {enabled: environment.production})
  ],

  // 作成したコンポーネント
  declarations: [
    RootComponent,
    ListComponent,
    EditComponent,
    SetComponent,
  ],

  // DIするサービス
  providers: [
    DataService,
    PermissionService,
    PushService,
    HttpClient,
    SwPush
  ],

  // 初めに呼び出すコンポーネント
  bootstrap: [RootComponent]

})
export class AppModule {
}
