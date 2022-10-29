import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { TruncatePipe } from './truncate.pipe';

describe('trucateパイプのテスト', () => {
  let pipe = new TruncatePipe();
  let msg = '12345678901234567890123456789012345678901234567890123456789012345';

  // パラメータをすべて省略した場合の挙動を確認
  it('デフォルトの挙動', () =>{
    expect(pipe.transform(msg)).toEqual(
      '12345678901234567890123456789012345678901234567890...');
  });

  // パラメータを指定した場合の挙動を確認
  it('パラメータの確認', () => {
    expect(pipe.transform(msg, 5, '～')).toEqual('12345～');
  });
});
