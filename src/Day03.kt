fun main() {

    fun String.toRuckSack() : RuckSack {
        val leftPocket = this.substring(0 until this.length/2).toSet()
        val rightPocket = this.substring(this.length/2..this.lastIndex).toSet()
        return RuckSack(leftPocket, rightPocket)
    }

    fun RuckSack.getCommonChar() : Char {
        return (this.first intersect this.second).single()
    }

    fun RuckSackGroup.getCommonChar() : Char {
        return (this[0] intersect this [1] intersect this[2]).single()
    }

    fun Char.getScore() : Int {
        return if (this.isUpperCase()) {
            this - 'A' + 27
        } else {
            this - 'a' + 1
        }
    }

    fun part1(input: List<String>): Int {
        return input.map(String::toRuckSack).map(RuckSack::getCommonChar).sumOf(Char::getScore)
    }

    fun part2(input: List<String>): Int {
        val groups = input.chunked(3)
        val rucksackGroups = ArrayList<RuckSackGroup>()
        for (group in groups) {
            val rucksackGroup = RuckSackGroup()
            for (rucksack in group) {
                rucksackGroup.add(rucksack.toSet())
            }
            rucksackGroups.add(rucksackGroup)
        }
        return rucksackGroups.map(RuckSackGroup::getCommonChar).sumOf(Char::getScore)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

typealias RuckSackGroup = ArrayList<Pocket>
typealias RuckSack = Pair<Pocket, Pocket>
typealias Pocket = Set<Char>




