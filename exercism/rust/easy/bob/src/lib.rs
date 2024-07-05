///
pub fn reply(message: &str) -> &str {
    let inputs = message.trim();
    let mut spaces = 0;
    let mut smalls = 0;
    let mut capitals = 0;
    let mut others = 0;
    let mut questions = false;
    let mut replies = "Whatever.";

    if inputs.ends_with("?") {
        questions = true;
    }
    for str in inputs.chars() {
        match str {
            ' ' => {
                spaces = spaces + 1;
            }
            'a'..='z' => {
                smalls = smalls + 1;
            }
            'A'..='Z' => {
                capitals = capitals + 1;
            }
            _ => {
                others = others + 1;
            }
        }
    }
    if capitals > 0 && inputs.len() == spaces + capitals + others {
        if questions == true {
            replies = "Calm down, I know what I'm doing!";
        } else {
            replies = "Whoa, chill out!";
        }
    } else {
        if inputs.len() == spaces {
            replies = "Fine. Be that way!";
        }
        if questions == true {
            replies = "Sure.";
        }
    }
    replies
}
