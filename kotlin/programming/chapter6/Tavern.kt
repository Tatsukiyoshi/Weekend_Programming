// リスト6-10
fun main(args: Array<String>) {
  var beverage = readLine()
  beverage?.let {
    beverage = it.capitalize()
  } ?: println("I can't do that without crashing - beverage was null!")
}
