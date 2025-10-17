// Task 5.1.1: anagram checking using a function
// File: Anagrams.kt

// Define infix extension function for String
infix fun String.anagramOf(other: String): Boolean {
    if (this.length != other.length) {
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = other.lowercase().toList().sorted()
    return firstChars == secondChars
}

fun main() {
    print("Input String 1: ")
    val str1 = readln()
    print("Input String 2: ")
    val str2 = readln()
    
    val result = str1 anagramOf str2
    
    println("Result: $result")
}
