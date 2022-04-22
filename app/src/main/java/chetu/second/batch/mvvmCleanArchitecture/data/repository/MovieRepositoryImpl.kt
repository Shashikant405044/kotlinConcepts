package chetu.second.batch.mvvmCleanArchitecture.data.repository

import android.util.Log
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import chetu.second.batch.mvvmCleanArchitecture.domain.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl
    (private val remoteMovieDataSourceImpl: RemoteMovieDataSourceImpl,
    private val localDbDataSourceImpl: LocalDbDataSourceImpl,
    private val cacheMovieDataSourceImpl: CacheMovieDataSourceImpl) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMovieFromCache()
    }

    override suspend fun updateMovie(): List<Movie> {
        val newMovieList = getMovieFromApi()
        localDbDataSourceImpl.clearMovie()
        localDbDataSourceImpl.saveMovieIntoDb(newMovieList)
        cacheMovieDataSourceImpl.saveMovieIntoCache(newMovieList)
        return newMovieList
    }

    suspend fun getMovieFromApi(): List<Movie> {
        lateinit var listMovie: List<Movie>
        val response: Response<List<Movie>> = remoteMovieDataSourceImpl.getMovie()
        if (response != null) {
            listMovie = response.body()!!
        }
        return listMovie
    }

    suspend fun getMovieFromLocalDB(): List<Movie> {
        lateinit var movieList : List<Movie>
        try {
            movieList = localDbDataSourceImpl.getMovieFromDb()
        }catch (exception : Exception){
            Log.d("MyTag", exception.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMovieFromApi()
            localDbDataSourceImpl.saveMovieIntoDb(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromCache() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = cacheMovieDataSourceImpl.getMovieFromCache()
        }catch (exception : Exception){
            Log.d("MyTag", exception.message.toString())
        }
        if (movieList.size > 0){
            return movieList
        }else{
            movieList = getMovieFromLocalDB()
            cacheMovieDataSourceImpl.saveMovieIntoCache(movieList)
        }
        return movieList
    }

}