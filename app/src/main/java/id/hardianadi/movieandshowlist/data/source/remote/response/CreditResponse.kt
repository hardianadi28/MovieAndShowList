package id.hardianadi.movieandshowlist.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreditResponse(

	@field:SerializedName("cast")
	val cast: List<CastItem?>? = null

) : Parcelable

@Parcelize
data class CastItem(

	@field:SerializedName("character")
	val character: String? = null,

	@field:SerializedName("credit_id")
	val creditId: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_path")
	val profilePath: String? = null
) : Parcelable

