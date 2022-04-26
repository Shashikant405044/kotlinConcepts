package chetu.second.batch.mvvmCleanArchitecture.data.repository

import android.util.Log
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import chetu.second.batch.mvvmCleanArchitecture.data.model.MovieList
import chetu.second.batch.mvvmCleanArchitecture.domain.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(private val movieRemoteDatasource : RemoteMovieDataSource,
                          private val movieLocalDatasource: LocalDbDataSource,
                          private val movieCacheDatasource: CacheMovieDataSource) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMovieFromCache()
    }

    override suspend fun updateMovie(): List<Movie> {
        val newMovieList = getMovieFromApi()
        movieLocalDatasource.clearMovie()
        movieLocalDatasource.saveMovieIntoDb(newMovieList)
        movieCacheDatasource.saveMovieIntoCache(newMovieList)
        return newMovieList
    }

    suspend fun getMovieFromApi(): List<Movie> {
        lateinit var movieList : List<Movie>
        try {
            val response : Response<MovieList> = movieRemoteDatasource.getMovie()
            val body : MovieList? = response.body()
            if (body!= null){
                movieList = body.movie
            }
        }catch (exception : Exception){
            Log.d("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMovieFromLocalDB(): List<Movie> {
        lateinit var movieList : List<Movie>
        try {
            movieList = movieLocalDatasource.getMovieFromDb()
        }catch (exception : Exception){
            Log.d("MyTag", exception.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMovieFromApi()
            movieLocalDatasource.saveMovieIntoDb(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromCache() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDatasource.getMovieFromCache()
        }catch (exception : Exception){
            Log.d("MyTag", exception.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMovieFromLocalDB()
            movieCacheDatasource.saveMovieIntoCache(movieList)
        }
        return movieList
    }

}