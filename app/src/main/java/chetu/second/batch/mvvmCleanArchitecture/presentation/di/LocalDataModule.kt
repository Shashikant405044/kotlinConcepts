package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import chetu.second.batch.mvvmCleanArchitecture.data.db.MovieDao
import chetu.second.batch.mvvmCleanArchitecture.data.repository.LocalDbDataSource
import chetu.second.batch.mvvmCleanArchitecture.data.repository.LocalDbDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
        @Singleton
        @Provides
        fun povideMovieLocalDataSource(movieDao: MovieDao) : LocalDbDataSource{
            return LocalDbDataSourceImpl(movieDao)
        }
}