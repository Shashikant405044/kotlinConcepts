package chetu.second.batch.mvvmCleanArchitecture.data.repository

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie

interface CacheMovieDataSource {
    suspend fun getMovieFromCache() : List<Movie>
    suspend fun saveMovieIntoCache(listMovie : List<Movie>)
}