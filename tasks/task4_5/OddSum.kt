// Task 4.5: summing odd integers with a for loop
fun main() {
    var sum = 0
    print("Input upper limit: ")
    val upLim = readln().toInt()
    for (n in 1..upLim step 2) {
        sum = sum + n
    }
    println(sum)
}