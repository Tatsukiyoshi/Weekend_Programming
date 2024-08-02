/// Return the Hamming distance between the strings,
/// or None if the lengths are mismatched.
pub fn hamming_distance(s1: &str, s2: &str) -> Option<usize> {
    let mut distance = 0;
    let left = s1.as_bytes();
    let right = s2.as_bytes();
    let times = left.len();

    if right.len() != times {
        return None;
    }

    for cnt in 0..times {
        if left[cnt] != right[cnt] {
            distance = distance + 1;
        }
    }

    Some(distance)
}
