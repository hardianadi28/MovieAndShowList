package id.hardianadi.movieandshowlist.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.data.CastEntity
import kotlinx.android.synthetic.main.item_cast_list.view.*

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @since 10/09/2020
 */
class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {
    private var castList = listOf<CastEntity>()
    fun setCastList(casts: List<CastEntity>) {
        castList = casts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cast_list, parent, false)
        return CastViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(castList[position])
    }

    override fun getItemCount(): Int = castList.size

    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cast: CastEntity) {
            with(itemView) {
                tvName.text = cast.name
                tvRole.text = cast.character

                Glide.with(context)
                    .load(cast.profilePath?: R.drawable.ic_broken_image_black)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

            }
        }
    }
}