//data class Year(val todo: Nothing) {
data class Year(val value: Int) {

    // TODO: Implement proper constructor
    val _year: Int = value

    val isLeap: Boolean = // TODO("Implement this getter to complete the task")
        if (_year % 4 > 0) false        // ４で割り切れない年は閏年ではない
        else if (_year % 100 > 0) true  // ４で割り切れるけど、１００で割り切れない年は閏年である
        else if (_year % 400 > 0) false // ４でも１００で割り切れるけど、４００で割り切れない年は閏年ではない
        else true                       // ４００で割り切れる年は閏年である
}
