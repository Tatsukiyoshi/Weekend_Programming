use lombok::*;
/// ## 14-2.データベース接続
/// ### リスト14.2 接続パラメータ構造体
#[derive(Getter,GetterMut,Setter,NoArgsConstructor,AllArgsConstructor,ToString,Clone)]
pub struct ConnectParams {
    host:       String, // 接続ホスト名
    port:       u16,    // TCPポート番号
    dbname:     String, // データベース名
    user:       String, // ユーザー名
    password:   String  // パスワード
}
impl ConnectParams {
    // 接続文字列を生成する
    pub fn connect_string(&self) -> String {
        format!("host={} port={} dbname={} user={} password={}",
            self.host, self.port, self.dbname, self.user, self.password)
    }
}
