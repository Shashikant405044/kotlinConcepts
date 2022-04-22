package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import chetu.second.batch.mvvmCleanArchitecture.domain.MovieRepository
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.GetMovieUseCase
import chetu.second.batch.mvvmCleanArchitecture.domain.useCases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMovieUseCase {
        return GetMovieUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository )
    }
}