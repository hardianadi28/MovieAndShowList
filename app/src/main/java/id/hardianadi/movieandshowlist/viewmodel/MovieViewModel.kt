package id.hardianadi.movieandshowlist.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import id.hardianadi.movieandshowlist.data.source.MovieShowRepository

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @since 09/09/2020
 */
class MovieViewModel @ViewModelInject constructor(private val mMovieShowRepository: MovieShowRepository) :
    ViewModel() {
    fun getMovieList() = mMovieShowRepository.getPopularMovies()
}