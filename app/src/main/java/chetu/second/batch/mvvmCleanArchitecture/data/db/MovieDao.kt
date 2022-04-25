package chetu.second.batch.mvvmCleanArchitecture.data.db

import androidx.room.*
import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie : List<Movie>)

    @Update
    suspend fun updateMovie(movie: List<Movie>)

    @Query("SELECT * FROM movie_table")
    suspend fun getMovie() : List<Movie>

    @Query("DELETE FROM movie_table")
    suspend fun clearAll()

}