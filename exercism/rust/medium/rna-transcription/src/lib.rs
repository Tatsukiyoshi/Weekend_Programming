#[derive(Debug, PartialEq, Eq)]
pub struct Dna{
    strands: String
}

#[derive(Debug, PartialEq, Eq)]
pub struct Rna {
    strands: String
}

impl Dna {
    pub fn new(dna: &str) -> Result<Dna, usize> {
        let input = dna.as_bytes();
        for idx in 0..input.len() {
            if input[idx] != u8::try_from('A').unwrap()
                && input[idx] != u8::try_from('C').unwrap()
                && input[idx] != u8::try_from('G').unwrap()
                && input[idx] != u8::try_from('T').unwrap()
            {
                return Err(idx);
            }
        }
        Ok(Self { strands: dna.to_string() })
    }

    /// RNA列の出力
    /// G -> C
    /// C -> G
    /// T -> A
    /// A -> U
    pub fn into_rna(self) -> Rna {
        let mut strands: String = "".to_string();
        for char in self.strands.chars() {
            match char {
                'A' => {
                    strands.push('U');
                },
                'C' => {
                    strands.push('G');
                },
                'G' => {
                    strands.push('C');
                }
                'T' => {
                    strands.push('A');
                }
                _ => {}
            }
        }
        let strands_str = strands.as_str();

        Rna::new(strands_str).unwrap()
    }
}

impl Rna {
    pub fn new(rna: &str) -> Result<Rna, usize> {
        let input = rna.as_bytes();
        for idx in 0..input.len() {
            if input[idx] != u8::try_from('A').unwrap()
                && input[idx] != u8::try_from('C').unwrap()
                && input[idx] != u8::try_from('G').unwrap()
                && input[idx] != u8::try_from('U').unwrap()
            {
                return Err(idx);
            }
        }
        Ok(Self { strands: rna.to_string() })
    }
}
