class Day02(private val input: List<String>) {
    data class Parsed(
        val min: Int,
        val max: Int,
        val char: String,
        val password: String
    )

    private fun parseLine(line: String):  Parsed? {
        val regex = """(\d+)-(\d+) (\w): (\w+)""".toRegex()
        val result = regex.find(line)
        return result?.let {
            val (min, max, char, password) = it.destructured
            return Parsed(min.toInt(), max.toInt(), char, password)
        }
    }

    private fun checkIsValid(line: String) : Boolean {
        val parsed = parseLine(line)
        var count = 0
        return parsed?.let {
            val charArr = it.password.toCharArray()
            charArr.forEach { char ->
                if (char.toString() == it.char) count++
            }

            return count >= it.min && count <= it.max
        } ?: false

    }

    fun solve1() {
        var valid = 0
        input.forEach { if(checkIsValid(it)) valid++ }
        println(valid)
    }
}