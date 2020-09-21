package id.hardianadi.movieandshowlist.ui.show

import android.graphics.text.LineBreaker
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.data.ShowEntity
import id.hardianadi.movieandshowlist.util.UtilFunction
import kotlinx.android.synthetic.main.item_movie_list.view.*

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
class ShowAdapter : RecyclerView.Adapter<ShowAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<ShowEntity>()

    private lateinit var onClickItemListener: OnClickItemListener

    fun setOnClickItemListener(onClickItemListener: OnClickItemListener) {
        this.onClickItemListener = onClickItemListener
    }

    fun setMovies(list: List<ShowEntity>?) {
        list?.let {
            listMovie.clear()
            listMovie.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val course = listMovie[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listMovie.size


    inner class MovieViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(data: ShowEntity) {
            with(itemView) {
                tvItemTitle.text = data.originalName
                tvItemSynopsis.text = data.overview
                tvItemYear.text = UtilFunction.stringDateFormat(data.firstAirDate)

                Glide.with(context)
                    .load(data.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    tvItemSynopsis.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
                }

                setOnClickListener { onClickItemListener.onClick(data) }
            }
        }
    }

    interface OnClickItemListener {
        fun onClick(movie: ShowEntity)
    }
}