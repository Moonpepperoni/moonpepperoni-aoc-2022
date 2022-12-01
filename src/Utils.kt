import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

val newLine = System.lineSeparator()

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("resources", "$name.txt")
    .readLines()

fun readInputBlankLines(name : String) = File("resources", "$name.txt")
    .readText().split("$newLine$newLine")

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
