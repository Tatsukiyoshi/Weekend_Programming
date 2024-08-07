fun transcribeToRna(dna: String): String = 
    dna.replace(Regex("[CGTA]")) {
        when (it.value) {
            "C" -> "G"
            "G" -> "C"
            "T" -> "A"
            "A" -> "U"
            else -> it.value
        }
    }
