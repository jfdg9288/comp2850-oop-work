import kotlin.random.Random
// Task 5.1.2: die rolling simulation
fun rollDie(sides: Int = 6) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
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
    val choice = readInt("Do you want to change the number of sides on the die from the default 6? (0 for no, 1 for yes)").toInt()
    if (choice == 1) {
        val dieRolls = readInt("How many number of sides for the die: ").toInt()
        rollDie(dieRolls)
    }
    else {
        rollDie()
    }
    
}