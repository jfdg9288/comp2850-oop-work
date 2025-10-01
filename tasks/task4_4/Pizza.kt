fun main() {
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")
    var x = "e"
    while (x !in "a".."d") {
        print("Choose your pizza (a-d): ")
        x = readln().lowercase()
        if (x.length == 1 && x in "a".."d") {
            println("Order accepted")
            break
        }
        else {
            println("Invalid choice. Try Again")
        }
    }   
}