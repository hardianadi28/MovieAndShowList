package id.hardianadi.movieandshowlist.util

import org.junit.Assert.*
import org.junit.Test

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
class StringDateFormatTest {

    @Test
    fun stringDateFormatTest() {
        val inputStringDate = "2020-09-18"
        val expectedFormatDate = "18-09-2020"

        val result = UtilFunction.stringDateFormat(inputStringDate)
        assertEquals(expectedFormatDate, result)
    }
}