package id.hardianadi.movieandshowlist.network

import id.hardianadi.movieandshowlist.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
interface NetworkService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<MovieListResponse>

    @GET("tv/popular")
    fun getPopularShow(): Call<ShowListResponse>

    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") id: String): Call<MovieResponse>

    @GET("tv/{id}")
    fun getShowDetail(@Path("id") id: String): Call<ShowResponse>

    @GET("movie/{id}/credits")
    fun getMovieCredit(@Path("id") id: String): Call<CreditResponse>

    @GET("tv/{id}/credits")
    fun getShowCredit(@Path("id") id: String): Call<CreditResponse>
}