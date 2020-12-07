import java.io.File
import java.io.InputStream

object Utils {
    fun getInputListAsInt(fileName: String) : List<Int> {
        val inputStream: InputStream = File(fileName).inputStream()
        val list = mutableListOf<Int>()
        inputStream.bufferedReader().forEachLine { list.add(it.toInt()) }
        return list
    }

    fun getInputList(fileName: String) : List<String> {
        val inputStream: InputStream = File(fileName).inputStream()
        val list = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { list.add(it) }
        return list
    }
}