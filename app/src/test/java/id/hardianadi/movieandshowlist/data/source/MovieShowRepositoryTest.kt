package id.hardianadi.movieandshowlist.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.hardianadi.movieandshowlist.data.source.remote.RemoteDataSource
import id.hardianadi.movieandshowlist.util.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
@RunWith(MockitoJUnitRunner::class)
class MovieShowRepositoryTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val repo = MovieShowRepository(remote)
    private val mockService = MockNetworkService()

    @Test
    fun `fetch popular movie list`() {
        val result = mockService.getPopularMovies().execute()
        `when`(remote.getPopularMovies()).thenReturn(retrofit2.mock.Calls.response(result))
        val movieEntities = LiveDataTestUtil.getValue(repo.getPopularMovies())
        verify(remote).getPopularMovies()
        assertNotNull(movieEntities)
        assertEquals(20, movieEntities.size)
    }

    @Test
    fun `fetch popular tv show list`() {
        val result = mockService.getPopularShow().execute()
        `when`(remote.getPopularShow()).thenReturn(retrofit2.mock.Calls.response(result))
        val showEntities = LiveDataTestUtil.getValue(repo.getPopularShow())
        verify(remote).getPopularShow()
        assertNotNull(showEntities)
        assertEquals(20, showEntities.size)
    }

    @Test
    fun `fetch movie detail`() {
        val result = mockService.getMovieDetail("").execute()
        `when`(remote.getMovieDetail(0)).thenReturn(retrofit2.mock.Calls.response(result))
        val movieEntity = LiveDataTestUtil.getValue(repo.getMovieDetail(0))
        verify(remote).getMovieDetail(0)
        assertNotNull(movieEntity)
        assertEquals("Mulan", movieEntity.title)
    }

    @Test
    fun `fetch show detail`() {
        val result = mockService.getShowDetail("").execute()
        `when`(remote.getShowDetail(0)).thenReturn(retrofit2.mock.Calls.response(result))
        val showEntity = LiveDataTestUtil.getValue(repo.getShowDetail(0))
        verify(remote).getShowDetail(0)
        assertNotNull(showEntity)
        assertEquals("The Boys", showEntity.originalName)
    }

    @Test
    fun `fetch movie credits`() {
        val result = mockService.getMovieCredit("").execute()
        `when`(remote.getMovieCredit(0)).thenReturn(retrofit2.mock.Calls.response(result))
        val movieCredit = LiveDataTestUtil.getValue(repo.getMovieCredit(0))
        verify(remote).getMovieCredit(0)
        assertNotNull(movieCredit)
        assertEquals("Liu Yifei", movieCredit[0].name)
    }

    @Test
    fun `fetch show credits`() {
        val result = mockService.getShowCredit("").execute()
        `when`(remote.getShowCredit(0)).thenReturn(retrofit2.mock.Calls.response(result))
        val showCredit = LiveDataTestUtil.getValue(repo.getShowCredit(0))
        verify(remote).getShowCredit(0)
        assertNotNull(showCredit)
        assertEquals("Karl Urban", showCredit[0].name)
    }

}