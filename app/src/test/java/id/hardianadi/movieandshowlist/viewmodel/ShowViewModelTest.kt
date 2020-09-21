package id.hardianadi.movieandshowlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @since 09/09/2020
 */
@RunWith(MockitoJUnitRunner::class)
class ShowViewModelTest {

    private lateinit var viewModel: ShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieShowRepository

    @Mock
    private lateinit var observer: Observer<List<ShowEntity>>

    @Before
    fun setup() {
        viewModel = ShowViewModel(repository)
    }

    @Test
    fun getShowList() {
        val dummyShowList = DataDummy.generateDummyShowList()
        val showList = MutableLiveData<List<ShowEntity>>()
        showList.value = dummyShowList

        `when`(repository.getPopularShow()).thenReturn(showList)
        val showEntities = viewModel.getShowList().value
        verify(repository).getPopularShow()
        assertNotNull(showEntities)
        assertEquals(20, showEntities?.size)

        viewModel.getShowList().observeForever(observer)
        verify(observer).onChanged(dummyShowList)

    }

}