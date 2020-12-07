class Day01(input: List<Int>) {
    private val list = input.sorted()

    private fun sumItems(start: Int, currIdx: Int, list: List<Int>) : List<Int>? {
        val target = 2020
        val next = list[currIdx]
        val sum = start + next

        return when {
            sum == target -> listOf(start, next)
            sum > target -> null
            else -> sumItems(start, currIdx + 1, list)
        }
    }

    private fun sumThree(v1: Int, v2: Int?, currIdx: Int, list: List<Int>) : List<Int>?{
        val target = 2020
        val val2 = v2 ?: list[currIdx]
        val sum = v1 + val2

        return when {
            sum >= target -> null
            sum < target -> {
                val match = sumItems(sum, currIdx + 1, list)
                match?.let {
                    return listOf(v1, val2, match[1])
                }
            }
            else -> sumThree(val2, null, currIdx + 1, list)
        }
    }

    fun solve1() {
        list.forEachIndexed { idx, i ->
            val match = sumItems(i, idx + 1, list)
            match?.let {
                val result = match[0] * match[1]
                println(result.toString())
                return
            }
        }
    }

    fun solve2() {
        list.forEachIndexed { idx, i ->
            val match = sumThree(i, null, idx + 1, list)
            match?.let {
                val result = match[0] * match[1] * match[2]
                println(result.toString())
                return
            }
        }
    }
}