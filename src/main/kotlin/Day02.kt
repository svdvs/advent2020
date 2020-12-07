class Day02(private val input: List<String>) {
    data class Parsed(
        val val1: Int,
        val val2: Int,
        val char: String,
        val password: String
    )

    private fun parseLine(line: String):  Parsed? {
        val regex = """(\d+)-(\d+) (\w): (\w+)""".toRegex()
        val result = regex.find(line)
        return result?.let {
            val (val1, val2, char, password) = it.destructured
            return Parsed(val1.toInt(), val2.toInt(), char, password)
        }
    }

    fun solve1() {
        var valid = 0
        input.forEach { line ->
            val parsed = parseLine(line)
            parsed?.let {
                var count = 0
                val charArr = it.password.toCharArray()
                charArr.forEach { char -> if (char.toString() == it.char) count++ }
                if (count >= it.val1 && count <= it.val2) valid++
            }
        }
        println(valid)
    }

    fun solve2() {
        var valid = 0
        input.forEach { line ->
            val parsed = parseLine(line)
            parsed?.let {
                var isValid = false

                isValid = it.password.getOrNull(it.val1 - 1).toString() == it.char
                if(it.password.getOrNull(it.val2 - 1).toString() == it.char) {
                    isValid = !isValid
                }
                if (isValid) valid++
            }
        }
        println(valid)
    }
}