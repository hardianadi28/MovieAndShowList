package id.hardianadi.movieandshowlist.data

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
data class ShowEntity(
    val id: Int? = 0,
    val originalName: String? = "",
    val posterPath: String? = "",
    val overview: String? = "",
    val firstAirDate: String? = "",
    val numberOfSeasons: Int? = 0
)