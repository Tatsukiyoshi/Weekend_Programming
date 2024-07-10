#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

/// リストの比較
/// - どちらも空・・・Equal
/// - いずれかが空・・・前者なら前者が後者のSublist、後者なら前者が後者のSuperlist
/// - 要素数が同じ・・・並びが同じならEqual、並びが異なるならUnequal
/// - 前者の要素数が多い・・・同じ並びがあるなら、前者が後者のSuperlist、並びが異なるならUnequal
/// - 後者の要素数が多い・・・同じ並びがあるなら、前者が後者のSublist、並びが異なるならUnequal
pub fn sublist<T: PartialEq>(_first_list: &[T], _second_list: &[T]) -> Comparison {
    let _first_len = _first_list.len();
    let _second_len = _second_list.len();

    if _first_len == 0 && _second_len == 0 {
        return Comparison::Equal
    }

    if _first_len == 0 {
        return Comparison::Sublist
    }

    if _second_len == 0 {
        return Comparison::Superlist
    }

    if _first_len == _second_len {
        for idx in 0.._first_len {
            if _first_list[idx] != _second_list[idx]{
                return Comparison::Unequal
            }
        }
        return Comparison::Equal
    }

    if _first_len > _second_len {
        let mut match_flag: bool;
        for first_idx in 0..(_first_len - _second_len + 1){
            match_flag = true;
            for second_idx in 0.._second_len {
                if _first_list[first_idx + second_idx] != _second_list[second_idx]{
                    match_flag = false;
                }
            }
            if match_flag == true {
                return Comparison::Superlist
            }
        }
        return Comparison::Unequal
    }

    if _first_len < _second_len {
        let mut match_flag: bool;
        for second_idx in 0..(_second_len - _first_len + 1) {
            match_flag = true;
            for first_idx in 0.._first_len {
                if _first_list[first_idx] != _second_list[second_idx + first_idx]{
                    match_flag = false;
                    break;
                }
            }
            if match_flag == true {
                return Comparison::Sublist
            }
        }
        return Comparison::Unequal
    }
    return Comparison::Unequal
}
