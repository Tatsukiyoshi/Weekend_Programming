//(1)パッケージのインポート
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ROUTES } from './app.routes';
import { Page01Component } from './page01.component';
import { Page02Component } from './page02.component';
import { StoreService } from './store.service';
import { ChildComponent } from './child.component';
import { ReactiveFormsModule } from '@angular/forms';

//(2)デコレーター
@NgModule({
  declarations: [
    AppComponent, Page01Component,
    Page02Component, ChildComponent
  ],
  imports: [  //(4)モジュールを登録
    BrowserModule, //(5)アプリ実行基本
    AppRoutingModule,
    ReactiveFormsModule,//(6)フォームコントロール用
    RouterModule.forRoot(ROUTES)//(7)ルータとルートマップの関連付け
  ],
  providers: [ //(8)DIするサービス
    StoreService
  ],
  bootstrap: [AppComponent] //(9)アプリ起動時コンポーネント
})
//(10)モジュールクラス定義
export class AppModule {
  //(11)コンストラクタ
  constructor() {
    console.log("@@@constructor");
  }
}
