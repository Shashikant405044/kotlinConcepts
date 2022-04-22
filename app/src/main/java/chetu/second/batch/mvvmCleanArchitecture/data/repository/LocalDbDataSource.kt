package chetu.second.batch.mvvmCleanArchitecture.data.repository

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie

interface LocalDbDataSource {
    suspend fun saveMovieIntoDb(movieList : List<Movie>)
    suspend fun getMovieFromDb() : List<Movie>
    suspend fun clearMovie()
}