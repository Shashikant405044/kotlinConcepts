package chetu.second.batch.mvvmCleanArchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.GetMovieUseCase
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.UpdateMovieUseCase

class MovieViewModel(private val getMovieUseCase: GetMovieUseCase,
                     private val updateMovieUseCase : UpdateMovieUseCase
): ViewModel() {

    fun getMovies() : LiveData<List<Movie>?> = liveData{
        val movieList : List<Movie>? = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() : LiveData<List<Movie>?> = liveData {
        val movieList : List<Movie>? = updateMovieUseCase.execute()
        emit(movieList)
    }
}