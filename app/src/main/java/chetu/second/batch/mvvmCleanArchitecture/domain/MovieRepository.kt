package chetu.second.batch.mvvmCleanArchitecture.domain

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>
    suspend fun updateMovie() : List<Movie>
}