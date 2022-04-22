package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import chetu.second.batch.mvvmCleanArchitecture.data.api.TMDBApi
import chetu.second.batch.mvvmCleanArchitecture.data.repository.RemoteMovieDataSource
import chetu.second.batch.mvvmCleanArchitecture.data.repository.RemoteMovieDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val apiKey : String){
    @Singleton
    @Provides
    fun provideRemoteDataSource(tmdbService: TMDBApi) : RemoteMovieDataSource{
        return RemoteMovieDataSourceImpl(tmdbService, apiKey)
    }
}