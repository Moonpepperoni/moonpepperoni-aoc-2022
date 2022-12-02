fun main() {

    fun String.toRPSNumerical() : Int {
        return if (this == "A" || this == "X") {
            0
        } else if (this == "B" || this == "Y") {
            1
        } else {
            2
        }
    }

    fun String.toGame() : Pair<Int, Int> {
        val strategy = this.split(" ")
        return strategy[0].toRPSNumerical() to strategy[1].toRPSNumerical()
    }

    fun Pair<Int,Int>.getResult() : Int {
        return (this.second + 1) + if (this.first == this.second) {
            3
        } else if ((this.first + 1) % 3 == this.second) {
            6
        } else {
            0
        }
    }

    fun part1(input: List<String>): Int {
        return input
            .map(String::toGame)
            .sumOf { it.getResult() }
    }

    fun Pair<Int, Int>.getScoreFor2() : Int {
        return when (this.second) {
            0 -> (this.first + 2) % 3 + 1
            1 -> this.first + 4
            else -> (this.first + 1) % 3 + 7
        }
    }

    fun part2(input: List<String>): Int {
        return input.map(String::toGame).sumOf(Pair<Int,Int>::getScoreFor2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}



