pub fn build_proverb(list: &[&str]) -> String {
    let mut rhyme: String = "".to_string();

    if list.len() > 0 {
        for i in 0..list.len() - 1{
            rhyme.push_str("For want of a ");
            rhyme.push_str(list[i]);
            rhyme.push_str(" the ");
            rhyme.push_str(list[i + 1]);
            rhyme.push_str(" was lost.\n");
        }
        rhyme.push_str("And all for the want of a ");
        rhyme.push_str(list[0]);
        rhyme.push_str(".");
    }

    rhyme
}
