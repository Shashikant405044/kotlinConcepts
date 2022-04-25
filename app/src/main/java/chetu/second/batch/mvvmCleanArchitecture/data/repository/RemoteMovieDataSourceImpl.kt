package chetu.second.batch.mvvmCleanArchitecture.data.repository

import chetu.second.batch.mvvmCleanArchitecture.data.api.TMDBApi
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import chetu.second.batch.mvvmCleanArchitecture.data.model.MovieList
import retrofit2.Response

class RemoteMovieDataSourceImpl(private val tmdbApi: TMDBApi,
                               private val apiKey : String) : RemoteMovieDataSource{
    override suspend fun getMovie(): Response<MovieList> {
        return tmdbApi.getMovie(apiKey)
    }
}