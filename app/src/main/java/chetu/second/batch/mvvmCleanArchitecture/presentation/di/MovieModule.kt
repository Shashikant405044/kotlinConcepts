package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.GetMovieUseCase
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.UpdateMovieUseCase
import chetu.second.batch.mvvmCleanArchitecture.presentation.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMovieUseCase: GetMovieUseCase, updateMovieUseCase: UpdateMovieUseCase) : MovieViewModelFactory{
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}