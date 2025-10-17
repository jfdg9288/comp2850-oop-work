// Implement the six required functions here
import java.io.File
import kotlin.random.Random

const val WORD_LENGTH = 5

fun isValid(word: String): Boolean = word.length == WORD_LENGTH && word.all{ it.isLetter() }

fun readWordList(filename: String): MutableList<String> =
    File(filename)
        .readLines()
        .map{ it.trim() } // remove whitespace
        .toMutableList()

fun pickRandomWord(words: MutableList<String>): String {
    val randNum = Random.nextInt(words.size)
    return words.removeAt(randNum)
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("\nAttempt $attempt: ")
        val input = readLine().orEmpty().trim().uppercase()
        if (isValid(input)) return input
        println("Invalid word. Please enter exactly 5 letters")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = MutableList(WORD_LENGTH) { 0 } //Starts all as 0
    val targetChars = target.toMutableList()

    // Check for exact matches
    for (i in 0 until WORD_LENGTH) {
        if (guess[i] == target[i]) {
            result[i] = 2
            targetChars[i] = '*' //mark this letter as used already
        }
    }

    // Check for partial matches
    for (i in 0 until WORD_LENGTH) {
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

    for (i in 0 until WORD_LENGTH) {
        val colour = when (matches[i]) {
            2 -> green
            1 -> yellow
            else -> gray
        }
        print("$colour${guess[i]}$reset")
    }
    println()
}