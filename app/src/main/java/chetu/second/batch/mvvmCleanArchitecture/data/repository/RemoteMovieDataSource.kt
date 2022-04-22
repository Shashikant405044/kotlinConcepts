package chetu.second.batch.mvvmCleanArchitecture.data.repository

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import retrofit2.Response

interface RemoteMovieDataSource {
    suspend fun getMovie() : Response<List<Movie>>
}