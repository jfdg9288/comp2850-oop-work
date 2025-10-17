// Task 5.1.1: anagram checking using a function
fun anagrams(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val firstChars = first.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars
}

fun main() {
    print("Input String 1: ")
    val str1 = readln()
    print("Input String 2: ")
    val str2 = readln()
    val result = anagrams(str1,str2)
    println("Result: $result")
}