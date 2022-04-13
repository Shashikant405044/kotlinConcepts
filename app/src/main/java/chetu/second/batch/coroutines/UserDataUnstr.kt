package chetu.second.batch.coroutines

import kotlinx.coroutines.*

class UserDataUnstr {
    lateinit var job : Deferred<Int>

    // TODO : must use coroutineScope with async
    suspend fun getCount() : Int{
        var count = 0
        coroutineScope {
           job = async {
                return@async count + 50
            }
        }
        return job.await()

//        coroutineScope {
//            launch {
//                count + 50
//            }
//        }
//        return count
    }
}