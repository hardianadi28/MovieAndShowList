package id.hardianadi.movieandshowlist.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieListResponse(

	@field:SerializedName("results")
	val results: List<MovieResponse?>? = null
) : Parcelable
