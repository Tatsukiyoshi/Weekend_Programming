import { Component } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ColoredDirective } from './colored.directive';

// myColoredディレクティブをホストするためのColoredTestComponentコンポーネント
@Component({
    selector: 'my-app',
    template: `
        <span [myColored]="color">Angular</span>です。
    `
})
export class ColoredTestComponent {
    color = '#ff00ff';
}

// テストスクリプト本体
describe('ColoredDirective', () => {
    let de: DebugElement;
    let comp: ColoredTestComponent;
    let fixture: ComponentFixture<ColoredTestComponent>;

    // rgv(255,255,255)形式の文字列を「#ffffff」形式に変換するヘルパー関数
    let rgb2hex = (color: string) => {
        let conv = (num: string) => {
            let tmp = parseInt(num).toString(16);
            return tmp.length === 1 ? '0' + tmp : tmp;
        };
        let cs = color.replace('rgb(', '').replace(')', '').split(',');
        return `#${conv(cs[0])}${conv(cs[1])}${conv(cs[2])}`;
    };

    // テストの前準備
    beforeEach(() => {
        // テストモジュールの宣言
        TestBed.configureTestingModule({
            declarations: [ ColoredTestComponent, ColoredDirective ]
        });

        // ホストコンポーネントをインスタンス化
        fixture = TestBed.createComponent(ColoredTestComponent);
        comp = fixture.componentInstance;
        de = fixture.debugElement.query(By.css('span'));
        fixture.detectChanges();    // プロパティ値をディレクティブに反映
    });

    // mouseover時に背景色が変化することを確認
    it('mouseover', () => {
        de.triggerEventHandler('mouseenter', de.nativeElement);
        fixture.detectChanges();    // イベントを反映
        let s = de.nativeElement.style;
        expect(rgb2hex(s.backgroundColor)).toEqual('#ff00ff');
    });
});
