class Day01(input: List<Int>) {
    private val list = input.sorted()

    private fun sumItems(currIdx: Int, nextIdx: Int, list: List<Int>) : List<Int>? {
        if (currIdx == nextIdx) return null

        val target = 2020
        val val1 = list[currIdx]
        val val2 = list[nextIdx]
        val sum = val1 + val2

        return when {
            sum == target -> listOf(val1, val2)
            sum < target -> null
            else -> sumItems(currIdx, nextIdx - 1, list)
        }
    }

    fun solve1() {
        list.forEachIndexed { idx, i ->
            val match = sumItems(idx, list.size - 1, list)
            match?.let {
                val result = match[0] * match[1]
                println(result.toString())
                return
            }
        }
    }
}