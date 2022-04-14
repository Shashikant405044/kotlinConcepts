package chetu.second.batch.roomDb.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
   @Insert
    suspend fun inserUser(user: User) : Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user_table")
    fun getUsers() : LiveData<List<User>>

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

}