fun main() {
    fun String.toCarriedCalories() = this.lines().sumOf { it.toInt() }

    fun part1(input: List<String>): Int {
        return input.maxOf(String::toCarriedCalories)
    }

    fun part2(input: List<String>): Int {
        return input
            .map(String::toCarriedCalories)
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputBlankLines("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInputBlankLines("Day01")
    println(part1(input))
    println(part2(input))
}



