package id.hardianadi.movieandshowlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.hardianadi.movieandshowlist.data.CastEntity
import id.hardianadi.movieandshowlist.data.ShowEntity
import id.hardianadi.movieandshowlist.data.source.MovieShowRepository
import id.hardianadi.movieandshowlist.util.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 18/09/2020
 */
@RunWith(MockitoJUnitRunner::class)
class ShowDetailViewModelTest {

    private lateinit var viewModel: ShowDetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieShowRepository

    @Mock
    private lateinit var observer: Observer<ShowEntity>

    @Mock
    private lateinit var observerCast: Observer<List<CastEntity>>

    @Before
    fun setup() {
        viewModel = ShowDetailViewModel(repository)
    }

    @Test
    fun getShow() {
        val dummyShow = DataDummy.generateDummyShow()
        val show = MutableLiveData<ShowEntity>()
        show.value = dummyShow

        Mockito.`when`(repository.getShowDetail(0)).thenReturn(show)
        val showEntity = viewModel.getShow(0).value
        Mockito.verify(repository).getShowDetail(0)
        assertNotNull(showEntity)
        assertEquals("The Boys", showEntity?.originalName)

        viewModel.getShow(0).observeForever(observer)
        Mockito.verify(observer).onChanged(dummyShow)
    }

    @Test
    fun getCast() {
        val dummyCastList = DataDummy.generateDummyShowCreditList()
        val castList = MutableLiveData<List<CastEntity>>()
        castList.value = dummyCastList

        Mockito.`when`(repository.getShowCredit(0)).thenReturn(castList)
        val castEntities = viewModel.getCast(0).value
        Mockito.verify(repository).getShowCredit(0)
        assertNotNull(castEntities)
        assertEquals(13, castEntities?.size)

        viewModel.getCast(0).observeForever(observerCast)
        Mockito.verify(observerCast).onChanged(dummyCastList)
    }
}