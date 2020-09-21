package id.hardianadi.movieandshowlist.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowListResponse(

	@field:SerializedName("results")
	val results: List<ShowResponse?>? = null
) : Parcelable