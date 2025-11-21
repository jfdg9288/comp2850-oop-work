import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here

    "isValid should accept exactly five letters and reject others" {
        isValid("APPLE") shouldBe true
        isValid("APPL") shouldBe false
        isValid("12345") shouldBe false
        isValid("APPL3") shouldBe false
        // add test for longer than 5 letters
        isValid("") shouldBe false
    }

    "readWordList should read lines from the file and trim whitespace" {
        val tmp = java.io.File.createTempFile("words", ".txt")
        tmp.writeText(
            """
            APPLE
            CRANE
              SHORT  
            EAGER
            LENGTHY
            """.trimIndent()
        )

        val words = readWordList(tmp.absolutePath)

        withClue("Should read exactly 5 lines") {
            words.size shouldBe 5
        }
        withClue("Should trim whitespace") {
            words shouldBe mutableListOf("APPLE", "CRANE", "SHORT", "EAGER", "LENGTHY")
        }
    }

    "pickRandomWord should return and remove an element" {
        val original = mutableListOf("APPLE", "CRANE", "SHORT")
        val picked = pickRandomWord(original)

        withClue("Picked word must have come from original list") {
            (picked in listOf("APPLE", "CRANE", "SHORT")) shouldBe true
        }
        withClue("Picked word must be removed from the original list") {
            (picked in original) shouldBe false
        }
        withClue("Size should be reduced by one") {
            original.size shouldBe 2
        }
    }

    "pickRandomWord should throw when list is empty" {
        val empty = mutableListOf<String>()
        val ex = runCatching { pickRandomWord(empty) }.exceptionOrNull()
        (ex is IllegalArgumentException) shouldBe true

    }

    "evaluateGuess should return 2 for green, 1 for yellow, 0 for gray (with duplicates handled)" {
        // All greens
        evaluateGuess("APPLE", "APPLE") shouldBe listOf(2, 2, 2, 2, 2)

        // Mixed (greens/yellows/grays)
        evaluateGuess("ALLEE", "APPLE") shouldBe listOf(2, 1, 0, 0, 2)

        // Repeated letters in guess more than in target
        evaluateGuess("BBBBB", "ABBEY") shouldBe listOf(0, 2, 2, 0, 0)

        // All yellows
        evaluateGuess("EABCD", "ABCDE") shouldBe listOf(1, 1, 1, 1, 1)

        // All greys
        evaluateGuess("FGHIJ", "ABCDE") shouldBe listOf(0, 0, 0, 0, 0)
    }
})
