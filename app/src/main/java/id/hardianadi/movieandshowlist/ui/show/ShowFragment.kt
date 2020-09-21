package id.hardianadi.movieandshowlist.ui.show

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.data.ShowEntity
import id.hardianadi.movieandshowlist.ui.detail.ShowDetailActivity
import id.hardianadi.movieandshowlist.viewmodel.ShowViewModel
import kotlinx.android.synthetic.main.fragment_show.*

@AndroidEntryPoint
class ShowFragment : Fragment(R.layout.fragment_show) {

    private val viewModel: ShowViewModel by viewModels()
    private val movieAdapter = ShowAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            progressBar.visibility = View.VISIBLE
            setObserver()
            setOnclickListener()
            prepareRecyclerView(movieAdapter)
        }
    }

    private fun setOnclickListener() {
        movieAdapter.setOnClickItemListener(object : ShowAdapter.OnClickItemListener {
            override fun onClick(movie: ShowEntity) {
                val intent = Intent(requireContext(), ShowDetailActivity::class.java)
                intent.putExtra(ShowDetailActivity.EXTRA_ID_MOVIE, movie.id)
                startActivity(intent)
            }

        })
    }

    private fun setObserver() {
        viewModel.getShowList().observe(viewLifecycleOwner, {
            movieAdapter.setMovies(it)
            progressBar.visibility = View.GONE
        })
    }

    private fun prepareRecyclerView(movieAdapter: ShowAdapter) {
        with(rvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}