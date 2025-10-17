// Task 6.4.2: anagram checking function

infix fun String.anagramOf(other: String) = when {
    this.isEmpty() && other.isEmpty() -> false
    this.length != other.length -> false
    else -> {
        val theseChars = this.lowercase().toList().sorted()
        val otherChars = other.lowercase().toList().sorted()
        theseChars == otherChars   
    }
}
