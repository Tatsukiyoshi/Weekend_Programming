pub struct Allergies{
    allergens: Vec<Allergen>
}

#[derive(Clone, Debug, PartialEq, Eq)]
pub enum Allergen {
    Eggs,
    Peanuts,
    Shellfish,
    Strawberries,
    Tomatoes,
    Chocolate,
    Pollen,
    Cats,
}

/// アレルギー判定
impl Allergies {
    /// 保有アレルギーの初期化
    /// - in:
    ///   - アレルギースコア
    /// - out:
    ///   - アレルギー構造体
    pub fn new(score: u32) -> Self {
        let mut inputs = score;
        let mut allergens: Vec<Allergen> = Vec::with_capacity(8);
        let mut allergen_bits: Vec<u32> = Vec::with_capacity(10);

        loop {
            allergen_bits.insert(0, inputs % 2);
            inputs = inputs / 2;
            if inputs < 2 {
                if inputs > 0 {
                    allergen_bits.insert(0, inputs);
                }
                break;
            }
        }
        println!("{:?}", allergen_bits);

        let bits_len = allergen_bits.len();
        for i in 0..bits_len {
            let pos = bits_len - i - 1;
            if allergen_bits[pos] == 1{
                match i {
                    0 => {
                        allergens.push(Allergen::Eggs);
                    }
                    1 => {
                        allergens.push(Allergen::Peanuts);
                    }
                    2 => {
                        allergens.push(Allergen::Shellfish);
                    }
                    3 => {
                        allergens.push(Allergen::Strawberries);
                    }
                    4 => {
                        allergens.push(Allergen::Tomatoes);
                    }
                    5 => {
                        allergens.push(Allergen::Chocolate);
                    }
                    6 => {
                        allergens.push(Allergen::Pollen);
                    }
                    7 => {
                        allergens.push(Allergen::Cats);
                    }
                    _ => {}
                }
            }
        }

        Self { allergens: allergens }
    }

    /// アレルギー判定
    /// - in:
    ///   - allergen: 判定したいアレルギー種別
    /// - out:
    ///   - 真偽値（true: 保有する、false: 保有しない）
    pub fn is_allergic_to(&self, allergen: &Allergen) -> bool {
        self.allergens.contains(allergen)
    }

    /// 保有アレルギーリストの取得
    /// out:
    /// - リスト（Vec<Allergen>）
    pub fn allergies(&self) -> Vec<Allergen> {
        let allergens = &self.allergens;
        allergens.to_vec()
    }
}
