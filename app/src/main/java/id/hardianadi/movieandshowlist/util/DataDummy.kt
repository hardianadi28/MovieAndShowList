package id.hardianadi.movieandshowlist.util

import id.hardianadi.movieandshowlist.data.CastEntity
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.data.ShowEntity
import id.hardianadi.movieandshowlist.data.source.remote.response.*

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @since 09/09/2020
 */
object DataDummy {

    fun generateDummyShowList(): List<ShowEntity>? {
        val responseObject = UtilFunction.parseJsonResponse(
            MockResponseFileReader.getContent("popular_tv_success_response.json"),
            ShowListResponse::class.java
        )

        return responseObject.results?.map { it?.toShowEntity() ?: ShowEntity() }
    }

    fun generateDummyMovieList(): List<MovieEntity>? {
        val responseObject = UtilFunction.parseJsonResponse(
            MockResponseFileReader.getContent("popular_movies_success_response.json"),
            MovieListResponse::class.java
        )

        return responseObject.results?.map { it?.toMovieEntity() ?: MovieEntity() }
    }

    fun generateDummyMovie(): MovieEntity {
        val responseObject = UtilFunction.parseJsonResponse(
            MockResponseFileReader.getContent("movie_detail_success_response.json"),
            MovieResponse::class.java
        )

        return responseObject.toMovieEntity()
    }

    fun generateDummyMovieCreditList(): List<CastEntity>? {
        val responseObject = UtilFunction.parseJsonResponse(
            MockResponseFileReader.getContent("movie_credits_success_response.json"),
            CreditResponse::class.java
        )

        return responseObject.cast?.map { it?.toCastEntity() ?: CastEntity() }
    }

    fun generateDummyShow(): ShowEntity {
        val responseObject = UtilFunction.parseJsonResponse(
            MockResponseFileReader.getContent("tv_detail_success_response.json"),
            ShowResponse::class.java
        )

        return responseObject.toShowEntity()
    }

    fun generateDummyShowCreditList(): List<CastEntity>? {
        val responseObject = UtilFunction.parseJsonResponse(
            MockResponseFileReader.getContent("tv_credits_success_response.json"),
            CreditResponse::class.java
        )

        return responseObject.cast?.map { it?.toCastEntity() ?: CastEntity() }
    }
}