use isbn_verifier::*;

#[test]
fn valid_isbn() {
    assert!(is_valid_isbn("3-598-21508-8"));
}

#[test]
fn invalid_isbn_check_digit() {
    assert!(!is_valid_isbn("3-598-21508-9"));
}

#[test]
fn valid_isbn_with_a_check_digit_of_10() {
    assert!(is_valid_isbn("3-598-21507-X"));
}

#[test]
fn check_digit_is_a_character_other_than_x() {
    assert!(!is_valid_isbn("3-598-21507-A"));
}

#[test]
fn invalid_check_digit_in_isbn_is_not_treated_as_zero() {
    assert!(!is_valid_isbn("4-598-21507-B"));
}

#[test]
fn invalid_character_in_isbn_is_not_treated_as_zero() {
    assert!(!is_valid_isbn("3-598-P1581-X"));
}

#[test]
fn x_is_only_valid_as_a_check_digit() {
    assert!(!is_valid_isbn("3-598-2X507-9"));
}

#[test]
fn valid_isbn_without_separating_dashes() {
    assert!(is_valid_isbn("3598215088"));
}

#[test]
fn isbn_without_separating_dashes_and_x_as_check_digit() {
    assert!(is_valid_isbn("359821507X"));
}

#[test]
fn isbn_without_check_digit_and_dashes() {
    assert!(!is_valid_isbn("359821507"));
}

#[test]
fn too_long_isbn_and_no_dashes() {
    assert!(!is_valid_isbn("3598215078X"));
}

#[test]
fn too_short_isbn() {
    assert!(!is_valid_isbn("00"));
}

#[test]
fn isbn_without_check_digit() {
    assert!(!is_valid_isbn("3-598-21507"));
}

#[test]
fn check_digit_of_x_should_not_be_used_for_0() {
    assert!(!is_valid_isbn("3-598-21515-X"));
}

#[test]
fn empty_isbn() {
    assert!(!is_valid_isbn(""));
}

#[test]
fn input_is_9_characters() {
    assert!(!is_valid_isbn("134456729"));
}

#[test]
fn invalid_characters_are_not_ignored_after_checking_length() {
    assert!(!is_valid_isbn("3132P34035"));
}

#[test]
fn invalid_characters_are_not_ignored_before_checking_length() {
    assert!(!is_valid_isbn("3598P215088"));
}

#[test]
fn input_is_too_long_but_contains_a_valid_isbn() {
    assert!(!is_valid_isbn("98245726788"));
}
