package id.hardianadi.movieandshowlist.ui.detail

import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.util.UtilFunction
import id.hardianadi.movieandshowlist.viewmodel.MovieDetailViewModel
import kotlinx.android.synthetic.main.activity_movie_detail.*

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID_MOVIE = "EXTRA_ID_MOVIE"
    }

    private val viewModel: MovieDetailViewModel by viewModels()
    private var idMovie = 0
    private val castAdapter: CastAdapter = CastAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        intent.extras?.let {
            idMovie = it.getInt(EXTRA_ID_MOVIE)
        }

        setObserver()
        prepareRecyclerView()

    }

    private fun setObserver() {
        viewModel.getMovie(idMovie).observe(this, {
            tvTitle.text = it.title
            tvYear.text = UtilFunction.stringDateFormat(it.releaseDate)
            tvSynopsis.text = it.overview
            tvRuntime.text = getString(R.string.runtime_minutes, it.runtime.toString())
            tvTagline.text = it.tagLine

            if(it.tagLine.isNullOrEmpty())tvTagline.visibility = View.GONE

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                tvSynopsis.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
            }

            Glide.with(this@MovieDetailActivity)
                .load(it.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imgPoster)

        })

        viewModel.getCast(idMovie).observe(this, {
            castAdapter.setCastList(it)
        })
    }

    private fun prepareRecyclerView() {
        with(rvCast) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = castAdapter
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}