package id.hardianadi.movieandshowlist.util

import id.hardianadi.movieandshowlist.data.CastEntity
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.data.ShowEntity
import id.hardianadi.movieandshowlist.data.source.remote.response.CastItem
import id.hardianadi.movieandshowlist.data.source.remote.response.MovieResponse
import id.hardianadi.movieandshowlist.data.source.remote.response.ShowResponse

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */


fun MovieResponse.toMovieEntity(): MovieEntity = MovieEntity(
    this.id,
    this.title,
    "https://image.tmdb.org/t/p/original/${this.posterPath}",
    this.overview,
    this.releaseDate,
    this.runtime,
    this.tagline
)

fun ShowResponse.toShowEntity(): ShowEntity = ShowEntity(
    this.id,
    this.originalName,
    "https://image.tmdb.org/t/p/original/${this.posterPath}",
    this.overview,
    this.firstAirDate,
    this.numberOfSeasons
)

fun CastItem.toCastEntity(): CastEntity = CastEntity(
    this.name,
    this.character,
    this.creditId,
    "https://image.tmdb.org/t/p/original/${this.profilePath}",
)

