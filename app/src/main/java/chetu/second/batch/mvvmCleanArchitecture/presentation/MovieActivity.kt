package chetu.second.batch.mvvmCleanArchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import chetu.second.batch.kotlinconcepts.R
import chetu.second.batch.kotlinconcepts.databinding.ActivityMovieAcctivityBinding
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import java.util.zip.Inflater
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    lateinit var movieViewModel: MovieViewModel
    private lateinit var binding : ActivityMovieAcctivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_acctivity)

        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        val responseLiveData : LiveData<List<Movie>?> = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.d("MyTag:", it.toString())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator : MenuInflater = menuInflater
        inflator.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_update){
            val responseLiveData : LiveData<List<Movie>?> = movieViewModel.updateMovies()
            responseLiveData.observe(this, Observer {
                Log.d("MyTag:", it.toString())
            })
        }
        return super.onOptionsItemSelected(item)
    }
}