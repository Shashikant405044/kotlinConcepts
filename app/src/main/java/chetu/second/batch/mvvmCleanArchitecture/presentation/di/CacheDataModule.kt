package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import chetu.second.batch.mvvmCleanArchitecture.data.repository.CacheMovieDataSource
import chetu.second.batch.mvvmCleanArchitecture.data.repository.CacheMovieDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideCacheDataSource() : CacheMovieDataSource{
        return CacheMovieDataSourceImpl()
    }
}