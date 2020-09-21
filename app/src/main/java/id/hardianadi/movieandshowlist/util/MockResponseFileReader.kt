package id.hardianadi.movieandshowlist.util

import java.io.InputStreamReader

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
object MockResponseFileReader {
    fun getContent(path: String): String {
        val content: String
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        content = reader.readText()
        reader.close()

        return content
    }
}