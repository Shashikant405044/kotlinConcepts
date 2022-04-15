package chetu.second.batch.roomDb.repository

import androidx.lifecycle.MutableLiveData
import chetu.second.batch.roomDb.db.User
import chetu.second.batch.roomDb.db.UserDao

class UserRepository(val dao: UserDao) {

    suspend fun insert(user: User){
        dao.insertUser(user)
    }

    suspend fun update(user: User){
        dao.updateUser(user)
    }

    suspend fun delete(user: User){
        dao.deleteUser(user)
    }

    suspend fun deleteAll(){
        dao.deleteAllUsers()
    }

    val users = dao.getUsers()

}