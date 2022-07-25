import java.lang.IllegalArgumentException

/**
 * Returns true if word2 is an anagram of word1.
 * This anagram check is case-insensitive.
 *
 * Word2 is considered an anagram of word1 if
 * word2 consists of the same letters as word1 rearranged in a different order.
 *
 * Constraints:
 * - A word is considered a string consisting of letters of the English
 *   alphabet only, i.e. a to z or A to Z. No lookup is done to verify, if the
 *   input actually is a valid English word.
 * - No white space or special characters are accepted, i.e. anagram phrases
 *   consisting of several words must be entered without spaces.
 * - The check is case-insensitive.
 * - Identical words are not considered an anagram.
 *
 * @param word1 string consisting of English-language letters
 * @param word2 anagram candidate to be checked
 * @return true if word2 is an anagram of word1, else false
 * @throws IllegalArgumentException if input does not contain English-alphabet
 * letters only (lower- or uppercase)
 */
fun isAnagram(word1: String, word2: String) : Boolean {

    val charArray1 = word1.toCharArray()
    val charArray2 = word2.toCharArray()

    assertLettersOnly(charArray1)
    assertLettersOnly(charArray2)

    return  !word1.equals(word2, ignoreCase= true) &&
            containSameLetters(charArray1, charArray2)
}

private fun assertLettersOnly(candidate: CharArray) {
    if (!candidate.all { c -> c in CharRange('a', 'z') || c in CharRange('A', 'Z') }) {
        throw IllegalArgumentException(
            "Only letters (a..z A..Z) are allowed. Found: ${String(candidate)}"
        )
    }
}


private fun containSameLetters(candidate1: CharArray, candidate2: CharArray) : Boolean {
    return candidate1.map { it.lowercaseChar() }.sorted() ==
            candidate2.map { it.lowercaseChar() }.sorted()
}


