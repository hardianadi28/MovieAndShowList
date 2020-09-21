package id.hardianadi.movieandshowlist.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.data.MovieEntity
import id.hardianadi.movieandshowlist.ui.detail.MovieDetailActivity
import id.hardianadi.movieandshowlist.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private val viewModel: MovieViewModel by viewModels()
    private val movieAdapter = MovieAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            progressBar.visibility = View.VISIBLE
            setObserver()
            setOnclickListener()
            prepareRecyclerView()
        }
    }

    private fun setOnclickListener() {
        movieAdapter.setOnClickItemListener(object : MovieAdapter.OnClickItemListener {
            override fun onClick(movie: MovieEntity) {
                val intent = Intent(requireContext(), MovieDetailActivity::class.java)
                intent.putExtra(MovieDetailActivity.EXTRA_ID_MOVIE, movie.id)
                startActivity(intent)
            }

        })
    }

    private fun setObserver() {

        viewModel.getMovieList().observe(viewLifecycleOwner, {
            movieAdapter.setMovies(it)
            progressBar.visibility = View.GONE
        })

    }

    private fun prepareRecyclerView() {
        with(rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

}