package id.hardianadi.movieandshowlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.data.source.MovieShowRepository
import id.hardianadi.movieandshowlist.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @since 09/09/2020
 */
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieShowRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setup() {
        viewModel = MovieViewModel(repository)
    }


    @Test
    fun getMovieList() {
        val dummyMovieList = DataDummy.generateDummyMovieList()
        val movieList = MutableLiveData<List<MovieEntity>>()
        movieList.value = dummyMovieList

        `when`(repository.getPopularMovies()).thenReturn(movieList)
        val showEntities = viewModel.getMovieList().value
        verify(repository).getPopularMovies()
        assertNotNull(showEntities)
        assertEquals(20, showEntities?.size)

        viewModel.getMovieList().observeForever(observer)
        verify(observer).onChanged(dummyMovieList)
    }
}