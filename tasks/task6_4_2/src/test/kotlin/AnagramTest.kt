// Task 6.4.2

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class AnagramTest: StringSpec({
    // Write your unit tests here!
    "Two strings of different lengths are not anagrams" {
        withClue("Two strings of different lengths are not anagrams") {
            ("ab" anagramOf "abc") shouldBe false
            ("hello" anagramOf "helloo") shouldBe false
        }
    }

    "An empty string is not an anagram of itself" {
        withClue("An empty string is not an anagram of itself") {
            ("" anagramOf "") shouldBe false
        }
    }

    "A non-empty string is an anagram of itself" {
        withClue("A non-empty string is an anagram of itself") {
            ("a" anagramOf "a") shouldBe true
            ("kotlin" anagramOf "kotlin") shouldBe true
        }
    }

    "Two strings are anagrams if they contain the same characters in a different order" {
        withClue("Two strings are anagrams if they contain the same characters in a different order") {
            ("listen" anagramOf "silent") shouldBe true
            ("triangle" anagramOf "integral") shouldBe true
        }
    }

    "Letter case is disregarded when comparing character sequences" {
        withClue("Letter case is disregarded when comparing character sequences") {
            ("AbC" anagramOf "cBa") shouldBe true
            ("Dormitory" anagramOf "dirtyroom") shouldBe true
        }
    }
})