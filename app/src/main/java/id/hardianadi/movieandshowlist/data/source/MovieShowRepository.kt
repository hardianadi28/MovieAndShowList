package id.hardianadi.movieandshowlist.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.hardianadi.movieandshowlist.data.CastEntity
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.data.ShowEntity
import id.hardianadi.movieandshowlist.data.source.remote.RemoteDataSource
import id.hardianadi.movieandshowlist.data.source.remote.response.*
import id.hardianadi.movieandshowlist.util.EspressoIdlingResource
import id.hardianadi.movieandshowlist.util.toCastEntity
import id.hardianadi.movieandshowlist.util.toMovieEntity
import id.hardianadi.movieandshowlist.util.toShowEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
class MovieShowRepository(private val remoteDataSource: RemoteDataSource) :
    MovieShowDataSource {

    companion object {
        const val TAG = "MovieShowRepository"
    }

    override fun getPopularMovies(): LiveData<List<MovieEntity>> {
        EspressoIdlingResource.increment()
        val movieResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getPopularMovies().enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse>,
                response: Response<MovieListResponse>
            ) {
                if (response.isSuccessful) {
                    movieResult.postValue(response.body()?.results?.map {
                        it?.toMovieEntity() ?: MovieEntity()
                    })
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                Log.e(TAG, t.message!!)
                EspressoIdlingResource.decrement()
            }

        })

        return movieResult
    }

    override fun getPopularShow(): LiveData<List<ShowEntity>> {
        EspressoIdlingResource.increment()
        val showResult = MutableLiveData<List<ShowEntity>>()
        remoteDataSource.getPopularShow().enqueue(object : Callback<ShowListResponse> {
            override fun onResponse(
                call: Call<ShowListResponse>,
                response: Response<ShowListResponse>
            ) {
                if (response.isSuccessful) {
                    showResult.postValue(response.body()?.results?.map {
                        it?.toShowEntity() ?: ShowEntity()
                    })
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ShowListResponse>, t: Throwable) {
                Log.e(TAG, t.message!!)
                EspressoIdlingResource.decrement()
            }

        })

        return showResult
    }

    override fun getMovieDetail(id: Int): LiveData<MovieEntity> {
        EspressoIdlingResource.increment()
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovieDetail(id).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                if (response.isSuccessful) {
                    movieResult.postValue(response.body()?.toMovieEntity())
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, t.message!!)
                EspressoIdlingResource.decrement()
            }

        })

        return movieResult
    }

    override fun getShowDetail(id: Int): LiveData<ShowEntity> {
        EspressoIdlingResource.increment()
        val movieResult = MutableLiveData<ShowEntity>()
        remoteDataSource.getShowDetail(id).enqueue(object : Callback<ShowResponse> {
            override fun onResponse(
                call: Call<ShowResponse>,
                response: Response<ShowResponse>
            ) {
                if (response.isSuccessful) {
                    movieResult.postValue(response.body()?.toShowEntity())
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ShowResponse>, t: Throwable) {
                Log.e(TAG, t.message!!)
                EspressoIdlingResource.decrement()
            }

        })

        return movieResult
    }

    override fun getMovieCredit(id: Int): LiveData<List<CastEntity>> {
        EspressoIdlingResource.increment()
        val castResult = MutableLiveData<List<CastEntity>>()
        remoteDataSource.getMovieCredit(id).enqueue(object : Callback<CreditResponse> {
            override fun onResponse(
                call: Call<CreditResponse>,
                response: Response<CreditResponse>
            ) {
                if (response.isSuccessful) {
                    castResult.postValue(response.body()?.cast?.map {
                        it?.toCastEntity() ?: CastEntity()
                    })
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<CreditResponse>, t: Throwable) {
                Log.e(TAG, t.message!!)
                EspressoIdlingResource.decrement()
            }

        })

        return castResult
    }

    override fun getShowCredit(id: Int): LiveData<List<CastEntity>> {
        EspressoIdlingResource.increment()
        val castResult = MutableLiveData<List<CastEntity>>()
        remoteDataSource.getShowCredit(id).enqueue(object : Callback<CreditResponse> {
            override fun onResponse(
                call: Call<CreditResponse>,
                response: Response<CreditResponse>
            ) {
                if (response.isSuccessful) {
                    castResult.postValue(response.body()?.cast?.map {
                        it?.toCastEntity() ?: CastEntity()
                    })
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<CreditResponse>, t: Throwable) {
                Log.e(TAG, t.message!!)
                EspressoIdlingResource.decrement()
            }

        })

        return castResult
    }
}