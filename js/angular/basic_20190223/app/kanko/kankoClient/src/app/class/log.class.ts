/**
 * メソッド用デコレータ
 * 1.対象メソッドの呼び出しと終了をログに出力します
 * 2.対象メソッドが Promise を返す場合、例外をcatchします
 */

// @Catch
export function Catch(isAutoCatch?: boolean) {
  return function (target, // クラス
                   name,　// メソッド名
                   descriptor // ディスクリプタ
  ) {
    // クラス名.メソッド名
    const location = target.constructor.name + '.' + name;
    // 加工前のメソッド
    const original = descriptor.value;

    if (typeof original === 'function') {

      // 加工したメソッドを保持
      descriptor.value = function (...args) {

        // ------------前処理---------------
        try {
          // ログ
          const nowString = (new Date()).toLocaleTimeString();
          console.log('%s call:%s(%s)', nowString, location,
            args.join(','));
        // --------------------------------

          // オリジナルのメソッド
          const result = original.apply(this, args);

        // ------------後処理---------------
          if (typeof isAutoCatch === undefined) {
            // 戻り値のPromise判定
            isAutoCatch = (result && typeof result.then === 'function' &&
              typeof result.catch === 'function');
          }
          // 戻り値がpromiseの時はcatchメソッドで例外検出
          if (isAutoCatch) {
            result.catch(err => {
              throw new Error(err.toString());
            });
          }
          // ログ
          console.log('%s return:%s %s %s ', nowString, location,
            (isAutoCatch ? 'isPromise' : ''), (result || ''));
        // --------------------------------

          return result;
        } catch (error) {
            console.log(error.toString());
            console.log('@@@@show alert');
          alert(`エラー ${error.message}`);
        }
        // --------------------------------
      };
    }
    return descriptor;
  };
}

/**
 * Promise用エラー処理
 * promiseのcatch文で利用
 * @param promise error obj
 */
export function promiseError(error) {
  console.error('promiseエラー');
  throw new Error(error.toString);
}

// /**
//  * 現在の日時を文字列で返す
//  * @returns 現在の日時の文字列
//  */
// export function getNowStr(){
//     return (new Date()).toLocaleTimeString();
// }
