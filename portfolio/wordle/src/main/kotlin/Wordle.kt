// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean {
    return word.length == 5 && word.all{it.isLetter()}
}

fun readWordList(filename: String): MutableList<String> {
    return File(filename)
        .readLines()
        .map{ it.trim() } // remove whitespace
        .toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
    val randNum = Random.nextInt(words.size)
    return words.removeAt(randNum)
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("\nAttempt $attempt: ")
        val input = readLine()?.trim()?.uppercase() ?: ""
        if (isValid(input)) return input
        println("Invalid word. Please enter exactly 5 letters")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = MutableList(5) {0} // Starts all letters as 0
    val targetChars = target.toMutableList()

    // Check for exact matches
    for (i in 0 until 5) {
        if (guess[i] == target[i]) {
            result[i] = 2
            targetChars[i] = '*' //mark this letter as used already
        }
    }

    // Check for partial matches
    for (i in 0 until 5) {
        if (result[i] == 0) { // Check if not already a green match
            val index = targetChars.indexOf(guess[i])
            if (index != -1) {
                result[i] = 1
                targetChars[index] = '*' // Again, to mark letter as used
            }
        }
    }
        return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val gray = "\u001B[37m"
    val reset = "\u001B[0m"

    for (i in 0 until 5) {
        val colour = when (matches[i]) {
            2 -> green
            1 -> yellow
            else -> gray
        }
        print("$colour${guess[i]}$reset")
    }
}