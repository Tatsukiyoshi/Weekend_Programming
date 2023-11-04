object Pangram {

    fun isPangram(input: String): Boolean {
        var result: Boolean = true
        val charCounter = mutableMapOf<Char, Boolean>()

        // loop of read
        input.forEach {
            // a to z character, counter of each character count-up
            if (it >= 'a' && it <= 'z') {
                // first-time -> OK
                if (charCounter[it] == null) {
                    charCounter[it] = true
                } else {
                    // secound-time -> NG
                    if (charCounter[it] == true) {
                       return false
                    }
                }
            }
        }
        "abcdefghijklmnopqrstuvwxyz".forEach {
            // not Encounter character 
            if (charCounter[it] == null) {
                result = false
            }
        }
        return result
    }
}
