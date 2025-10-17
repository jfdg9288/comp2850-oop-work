const val MAX_ATTEMPTS = 6

fun main() {
    val words = try {
        readWordList("data/words.txt")
    } catch (e: Exception) {
        println("Error: Could not read word file (${e.message}).")
        return
    }

    if (words.isEmpty()) {
        println("Error: Word file contains no words.")
        return
    }

    val target = try {
        pickRandomWord(words)
    } catch (e: IllegalArgumentException) {
        println("Error: No words available to choose from.")
        return
    }

    println("Wordle: Guess the 5-letter word.\n")

    for (attempt in 1..MAX_ATTEMPTS) {
        val guess = obtainGuess(attempt) // ask user for input until valid
        val result = evaluateGuess(guess.lowercase(), target.lowercase())
        displayGuess(guess.lowercase(), result)

        if (result.all { it == 2 }) {
            print("\nYou guessed the word \"$target\" in $attempt attempt${if (attempt == 1) "" else "s"}!")
            return
        }
    }
    println("\nOut of guesses! The word was \"$target\".")
}
