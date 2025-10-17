// Task 5.3.2: die rolling simulation
import kotlin.random.Random
fun rollDie(numOfDice: Int = 1, sides: Int = 6, ) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        var total = 0
        for (diceRolls in 1..numOfDice) {
            println("Rolling a d$sides...")
            val result = Random.nextInt(1, sides + 1)
            println("You rolled $result")
            total += result
        }
        println("Total is $total")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun readInt(str: String): Int {
    print(str)
    return readln().toInt()
}

fun main() {
    val numDice = readInt("How many number of dice: ").toInt()
    val dieRolls = readInt("How many number of sides for the die: ").toInt()
    println("rollDie(numDice, dieRolls)")
    rollDie(numDice, dieRolls)
    println("rollDie(numDice)")
    rollDie(numDice)
    println("rollDie(sides = dieRolls)")
    rollDie(sides = dieRolls)
    
}