package chetu.second.batch.mvvmCleanArchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.GetMovieUseCase
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.UpdateMovieUseCase
import java.lang.IllegalArgumentException

class MovieViewModelFactory(private val getMovieUseCase: GetMovieUseCase,
                            private val updateMovieUseCase : UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
        }

        throw IllegalArgumentException("unknown view model class")
    }
}