pub fn verse(n: u32) -> String {
    let mut m = n;
    let verse_str: String = match m {
        0 => {
            let mut str = "No more bottles of beer on the wall, no more bottles of beer.\n".to_string();
            str.push_str("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
            str
        }
        1 => {
            let mut str = m.to_string();
            str.push_str(" bottle of beer on the wall, ");
            str.push_str(&*m.to_string());
            str.push_str(" bottle of beer.\n");
            str.push_str("Take it down and pass it around, no more bottles of beer on the wall.\n");
            str
        }
        _ => {
            let mut str: String = m.to_string();
            str.push_str(" bottles of beer on the wall, ");
            str.push_str(&*m.to_string());
            str.push_str(" bottles of beer.\nTake one down and pass it around, ");
            m = m - 1;
            str.push_str(&*m.to_string());
            if m == 1 {
                str.push_str(" bottle of beer on the wall.\n");
            } else {
                str.push_str(" bottles of beer on the wall.\n");
            }
            str
        }
    };
    verse_str
}

pub fn sing(start: u32, end: u32) -> String {
    let mut songs: String = "".to_string();

    for i in (end..start + 1).rev() {
        let str = verse(i);
        songs.push_str(&*str);
        if i > end {
            songs.push_str("\n");
        }
    }
    songs
}
