package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import chetu.second.batch.mvvmCleanArchitecture.data.repository.*
import chetu.second.batch.mvvmCleanArchitecture.domain.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDatasource: RemoteMovieDataSource,
                                movieLocalDatasource: LocalDbDataSource,
                                movieCacheDatasource: CacheMovieDataSource) : MovieRepository {
                                return MovieRepositoryImpl(movieRemoteDatasource, movieLocalDatasource, movieCacheDatasource)
    }
}