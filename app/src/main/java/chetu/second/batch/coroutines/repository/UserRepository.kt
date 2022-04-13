package chetu.second.batch.coroutines.repository

import chetu.second.batch.model.User
import kotlinx.coroutines.delay

class UserRepository {
    // DB/Retrofit
    fun getData(): List<User> {
//        delay(3000)
        var list = listOf<User>(
            User(1, "A"),
            User(2, "B"),
            User(3, "C"),
            User(4, "D")
        )
        return list
    }
}