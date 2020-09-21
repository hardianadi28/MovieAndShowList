package id.hardianadi.movieandshowlist.data.source

import id.hardianadi.movieandshowlist.MockResponseFileReader
import id.hardianadi.movieandshowlist.data.source.remote.response.*
import id.hardianadi.movieandshowlist.network.NetworkService
import id.hardianadi.movieandshowlist.util.UtilFunction.parseJsonResponse
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
class MockNetworkService : NetworkService {
    override fun getPopularMovies(): Call<MovieListResponse> {
        return object : Call<MovieListResponse> {
            override fun clone(): Call<MovieListResponse> {
                return this
            }

            override fun execute(): Response<MovieListResponse> {
                val responseOject =
                    parseJsonResponse(
                        MockResponseFileReader("popular_movies_success_response.json").content,
                        MovieListResponse::class.java
                    )
                return Response.success(responseOject)
            }

            override fun enqueue(callback: Callback<MovieListResponse>) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }

    override fun getPopularShow(): Call<ShowListResponse> {
        return object : Call<ShowListResponse> {
            override fun clone(): Call<ShowListResponse> {
                return this
            }

            override fun execute(): Response<ShowListResponse> {
                val responseOject =
                    parseJsonResponse(
                        MockResponseFileReader("popular_tv_success_response.json").content,
                        ShowListResponse::class.java
                    )
                return Response.success(responseOject)
            }

            override fun enqueue(callback: Callback<ShowListResponse>) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }

    override fun getMovieDetail(id: String): Call<MovieResponse> {
        return object : Call<MovieResponse> {
            override fun clone(): Call<MovieResponse> {
                return this
            }

            override fun execute(): Response<MovieResponse> {
                val responseOject =
                    parseJsonResponse(
                        MockResponseFileReader("movie_detail_success_response.json").content,
                        MovieResponse::class.java
                    )
                return Response.success(responseOject)
            }

            override fun enqueue(callback: Callback<MovieResponse>) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }

    override fun getShowDetail(id: String): Call<ShowResponse> {
        return object : Call<ShowResponse> {
            override fun clone(): Call<ShowResponse> {
                return this
            }

            override fun execute(): Response<ShowResponse> {
                val responseOject =
                    parseJsonResponse(
                        MockResponseFileReader("tv_detail_success_response.json").content,
                        ShowResponse::class.java
                    )
                return Response.success(responseOject)
            }

            override fun enqueue(callback: Callback<ShowResponse>) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }

    override fun getMovieCredit(id: String): Call<CreditResponse> {
        return object : Call<CreditResponse> {
            override fun clone(): Call<CreditResponse> {
                return this
            }

            override fun execute(): Response<CreditResponse> {
                val responseOject = parseJsonResponse(
                    MockResponseFileReader("movie_credits_success_response.json").content,
                    CreditResponse::class.java
                )
                return Response.success(responseOject)
            }

            override fun enqueue(callback: Callback<CreditResponse>) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }

    override fun getShowCredit(id: String): Call<CreditResponse> {
        return object : Call<CreditResponse> {
            override fun clone(): Call<CreditResponse> {
                return this
            }

            override fun execute(): Response<CreditResponse> {
                val responseOject =
                    parseJsonResponse(
                        MockResponseFileReader("tv_credits_success_response.json").content,
                        CreditResponse::class.java
                    )
                return Response.success(responseOject)
            }

            override fun enqueue(callback: Callback<CreditResponse>) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request {
                return Request.Builder().build()
            }

            override fun timeout(): Timeout {
                return Timeout()
            }

        }
    }
}