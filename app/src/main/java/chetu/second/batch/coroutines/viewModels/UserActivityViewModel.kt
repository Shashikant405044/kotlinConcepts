package chetu.second.batch.coroutines.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chetu.second.batch.coroutines.repository.UserRepository
import chetu.second.batch.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserActivityViewModel : ViewModel(){
    var userRepository: UserRepository = UserRepository()
    var user : MutableLiveData<List<User>> = MutableLiveData<List<User>>()


    fun getUserData(){
        viewModelScope.launch {
            var list : List<User>
            list = userRepository.getData()
//            withContext(Dispatchers.Main){
//                list = userRepository.getData()
//            }
            Log.d("DATA", ""+list)
            user.value = list
        }

    }
}