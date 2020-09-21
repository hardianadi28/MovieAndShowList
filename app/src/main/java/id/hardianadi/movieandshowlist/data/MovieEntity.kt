package id.hardianadi.movieandshowlist.data

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
data class MovieEntity(
    val id: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val overview: String? = "",
    val releaseDate: String? = "",
    val runtime: Int? = 0,
    val tagLine: String? = ""
)