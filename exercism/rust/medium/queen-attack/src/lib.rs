#[derive(Debug)]
/// 駒の位置
/// rank: ランク（横の列）
/// file: ファイル（縦の列）
pub struct ChessPosition {
    rank:   i32,
    file:   i32
}

#[derive(Debug)]
/// チェスの駒：女王
/// chess_position: 駒の位置（ランクとファイル）
pub struct Queen {
    chess_position: ChessPosition
}

impl ChessPosition {
    /// ChessPosition（駒の位置）の初期化
    /// 盤上に配置できるかをチェックし、
    /// できる場合は、ChessPositionを返却する
    /// できない場合は、Noneを返却する
    pub fn new(rank: i32, file: i32) -> Option<Self> {
        if rank < 0 || rank > 7 {
            return None;
        }
        if file < 0 || file > 7 {
            return None;
        }
        Some(Self { rank, file })
    }
}

impl Queen {
    /// Queen（チェスの駒）の初期化
    /// - 入力
    ///   - 駒の位置
    /// - 出力
    ///   - 指定された駒の位置を設定したQueen
    pub fn new(position: ChessPosition) -> Self {
        Queen { chess_position: position}
    }

    /// 指定された駒を攻撃できるかを判定する
    /// - 入力
    ///   - 攻撃対象の駒
    /// - 出力
    ///   - 判定結果（true: 攻撃できる、false: 攻撃できない）
    pub fn can_attack(&self, other: &Queen) -> bool {
        let mut attack_flag: bool = false;

        if self.chess_position.rank == other.chess_position.rank {
            attack_flag = true;
        }
        if self.chess_position.file == other.chess_position.file {
            attack_flag = true;
        }
        if (self.chess_position.file - other.chess_position.file).abs()
        == (self.chess_position.rank - other.chess_position.rank).abs() {
            attack_flag = true;
        }

        attack_flag
    }
}
