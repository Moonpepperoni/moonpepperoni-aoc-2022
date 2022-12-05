fun main() {

    fun String.sectionPairs() : Pair<IntRange, IntRange> {
        val inputPattern = """(\d+)-(\d+),(\d+)-(\d+)""".toRegex()
        val (firstStart, firstEnd, secondStart, secondEnd) = inputPattern.matchEntire(this)?.destructured ?: error("Input incorrect")
        return firstStart.toInt()..firstEnd.toInt() to secondStart.toInt()..secondEnd.toInt()
    }

    fun SectionPair.overlapEntirely() : Boolean {
        return (second.first in first && second.last in first) || (first.first in second && first.last in second)
    }

    fun SectionPair.overlapPartly() : Boolean {
        return (second.first in first || second.last in first || first.first in second || first.last in second)
    }

    fun part1(input: List<String>): Int {
        return input.map(String::sectionPairs).count(SectionPair::overlapEntirely)
    }

    fun part2(input: List<String>): Int {
        return input.map(String::sectionPairs).count(SectionPair::overlapPartly)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}

typealias SectionPair = Pair<IntRange,IntRange>






