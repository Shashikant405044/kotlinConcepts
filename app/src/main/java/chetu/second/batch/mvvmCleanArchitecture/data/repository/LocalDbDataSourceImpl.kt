package chetu.second.batch.mvvmCleanArchitecture.data.repository

import chetu.second.batch.mvvmCleanArchitecture.data.db.MovieDao
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDbDataSourceImpl(private val dao : MovieDao) : LocalDbDataSource{
    override suspend fun saveMovieIntoDb(movieList: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertMovie(movieList)
        }
    }

    override suspend fun getMovieFromDb(): List<Movie> {
        return dao.getMovie()
    }

    override suspend fun clearMovie() {
        dao.clearAll()
    }
}