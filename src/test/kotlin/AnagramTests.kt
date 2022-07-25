import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test



class AnagramTests {

    @Test
    fun `a valid anagram is recognized correctly`() {
        assertTrue(isAnagram("aaabcde", "cbaaade"))
    }

    @Test
    fun `the number of occurrences are taken into account`() {
        assertFalse(isAnagram("aaabcde", "cbade"))
    }

    @Test
    fun `identical words are not an anagram`() {
        assertFalse(isAnagram("abcde", "abcde"))
    }

    @Test
    fun `check for identical words ignores case`() {
        assertFalse(isAnagram("ABCDE", "abcde"))
    }

    @Test
    fun `lower case and upper case are not relevant`() {
        assertTrue(isAnagram("Abcde", "Cbade"))
    }

    @Test
    fun `exception is thrown if input does not consist of letters only`() {
        val illegalWord = "a!?bc"
        assertThatThrownBy { isAnagram(illegalWord,"bc?!a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(illegalWord)
    }

}