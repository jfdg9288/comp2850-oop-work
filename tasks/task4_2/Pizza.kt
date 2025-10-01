fun main() {
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")
    print("Choose your pizza (a-d): ")
    val input = readln().lowercase()
    if (input.length == 1 && input[0] in 'a'..'d') {
        println("Order accepted")
    }
    else {
        println("Invalid choice")
    }
}