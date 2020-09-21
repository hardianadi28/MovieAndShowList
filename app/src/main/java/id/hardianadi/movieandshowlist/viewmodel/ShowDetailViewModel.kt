package id.hardianadi.movieandshowlist.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import id.hardianadi.movieandshowlist.data.source.MovieShowRepository

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
class ShowDetailViewModel @ViewModelInject constructor(private val mMovieShowRepository: MovieShowRepository) :
    ViewModel() {

    fun getShow(id: Int) = mMovieShowRepository.getShowDetail(id)
    fun getCast(id: Int) = mMovieShowRepository.getShowCredit(id)
}