package chetu.second.batch.MvvmCleanArchitecture.data.api

import chetu.second.batch.MvvmCleanArchitecture.data.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
   @GET("/movie/popular")
   suspend fun getMovie(@Query("api_key") apikey : String) : List<Movie>
}