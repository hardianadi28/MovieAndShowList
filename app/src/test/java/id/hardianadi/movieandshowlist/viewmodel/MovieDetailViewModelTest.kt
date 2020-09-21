package id.hardianadi.movieandshowlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.hardianadi.movieandshowlist.data.CastEntity
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.data.source.MovieShowRepository
import id.hardianadi.movieandshowlist.util.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieShowRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Mock
    private lateinit var observerCast: Observer<List<CastEntity>>

    @Before
    fun setup() {
        viewModel = MovieDetailViewModel(repository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(repository.getMovieDetail(0)).thenReturn(movie)
        val movieEntity = viewModel.getMovie(0).value
        verify(repository).getMovieDetail(0)
        assertNotNull(movieEntity)
        assertEquals("Mulan", movieEntity?.title)

        viewModel.getMovie(0).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getCast() {
        val dummyCastList = DataDummy.generateDummyMovieCreditList()
        val castList = MutableLiveData<List<CastEntity>>()
        castList.value = dummyCastList

        `when`(repository.getMovieCredit(0)).thenReturn(castList)
        val castEntities = viewModel.getCast(0).value
        verify(repository).getMovieCredit(0)
        assertNotNull(castEntities)
        assertEquals(32, castEntities?.size)

        viewModel.getCast(0).observeForever(observerCast)
        verify(observerCast).onChanged(dummyCastList)
    }
}