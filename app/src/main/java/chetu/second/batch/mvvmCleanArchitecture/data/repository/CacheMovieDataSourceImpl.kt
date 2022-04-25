package chetu.second.batch.mvvmCleanArchitecture.data.repository

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie

class CacheMovieDataSourceImpl : CacheMovieDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMovieFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieIntoCache(listMovie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(listMovie)
    }
}