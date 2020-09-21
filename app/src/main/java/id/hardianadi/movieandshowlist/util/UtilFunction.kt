package id.hardianadi.movieandshowlist.util

import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
object UtilFunction {

    fun stringDateFormat(date: String?): String {
        val inputDate = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date!!)
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)

        return formatter.format(inputDate!!)
    }

    inline fun <reified T>parseJsonResponse(mockResponse: String, clazz: Class<T>): T {
        return Gson().fromJson(mockResponse, T::class.java)
    }

}