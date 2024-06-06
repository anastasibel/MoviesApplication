package com.dz.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var moviesDataSource: MoviesDataSource
    lateinit var moviesList: List<Movie>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        recycler = view.findViewById(R.id.grid_recycler)
        recycler.layoutManager = layoutManager

        moviesDataSource = MoviesDataSource()
        moviesList = moviesDataSource.getMovies()

        recycler.adapter = MovieAdapter(moviesList)

        /*
        view.findViewById<ImageView>(R.id.movie_image).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesDetails())
                .addToBackStack(null)
                .commit()
        }
        */
    }
}