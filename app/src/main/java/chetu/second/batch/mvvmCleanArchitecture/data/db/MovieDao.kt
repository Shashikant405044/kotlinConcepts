package chetu.second.batch.mvvmCleanArchitecture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovie(movie : List<Movie>)

    @Update
    suspend fun updateMovie(movie: List<Movie>)

    @Query("SELECT * FROM movie_table")
    suspend fun getMovie() : List<Movie>

    @Query("DELETE FROM movie_table")
    suspend fun clearAll()

}