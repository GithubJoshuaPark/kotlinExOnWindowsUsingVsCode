package main.kotlin.utils

class StringUtils {
    companion object {
        // Unicode ranges for Korean characters
        private val HANGUL_JAMO_START = 0x1100
        private val HANGUL_JAMO_END = 0x11FF
        private val HANGUL_COMPATIBILITY_START = 0x3130
        private val HANGUL_COMPATIBILITY_END = 0x318F
        private val HANGUL_SYLLABLES_START = 0xAC00
        private val HANGUL_SYLLABLES_END = 0xD7AF
    }

    /**
     * Prints a string with a border of dashes.
     * Handles both single-width (ASCII) and double-width (Korean) characters.
     * 
     * Example:
     * printLine("Hello 안녕")
     * -----------
     * Hello 안녕
     * -----------
     *
     * @param str The string to print
     */
    fun printLine(str: String) {
        if (str.isEmpty()) return

        println()
        val displayWidth = str.sumOf { char: Char -> 
            when (char.code) {
                in HANGUL_JAMO_START..HANGUL_JAMO_END,
                in HANGUL_COMPATIBILITY_START..HANGUL_COMPATIBILITY_END,
                in HANGUL_SYLLABLES_START..HANGUL_SYLLABLES_END -> 2L
                else -> 1L
            }
        }.toInt()
    
        val border = "-".repeat(displayWidth)
        println(border)
        println(str)
        println(border)
    }
}