package id.hardianadi.movieandshowlist.data.source

import androidx.lifecycle.LiveData
import id.hardianadi.movieandshowlist.data.CastEntity
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.data.ShowEntity

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
interface MovieShowDataSource {

    fun getPopularMovies(): LiveData<List<MovieEntity>>

    fun getPopularShow(): LiveData<List<ShowEntity>>

    fun getMovieDetail(id: Int): LiveData<MovieEntity>

    fun getShowDetail(id: Int): LiveData<ShowEntity>

    fun getMovieCredit(id: Int): LiveData<List<CastEntity>>

    fun getShowCredit(id: Int): LiveData<List<CastEntity>>
}