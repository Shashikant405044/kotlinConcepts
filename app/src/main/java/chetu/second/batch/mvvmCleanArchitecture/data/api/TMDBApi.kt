package chetu.second.batch.mvvmCleanArchitecture.data.api

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
   @GET("/movie/popular")
   suspend fun getMovie(@Query("api_key") apikey : String) : Response<List<Movie>>
}