package id.hardianadi.movieandshowlist.data.source.remote

import id.hardianadi.movieandshowlist.network.NetworkService

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
class RemoteDataSource(private val networkService: NetworkService) {

    fun getPopularMovies() = networkService.getPopularMovies()

    fun getPopularShow() = networkService.getPopularShow()

    fun getMovieDetail(id: Int) = networkService.getMovieDetail(id.toString())

    fun getShowDetail(id: Int) = networkService.getShowDetail(id.toString())

    fun getMovieCredit(id: Int) = networkService.getMovieCredit(id.toString())

    fun getShowCredit(id: Int) = networkService.getShowCredit(id.toString())
}