package chetu.second.batch.roomDb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chetu.second.batch.roomDb.db.User
import chetu.second.batch.roomDb.repository.UserRepository
import kotlinx.coroutines.launch

class UserDetailsViewModel(val userRepository: UserRepository) : ViewModel() {

    var firstName =  MutableLiveData<String?>()
    var lastName = MutableLiveData<String?>()
    var mobileNo = MutableLiveData<String?>()

    var saveOrUpdate = MutableLiveData<String>()
    var clearAllOrDelete = MutableLiveData<String>()

    init {
        saveOrUpdate.value = "Save" // setting value to MutableLiveData
        clearAllOrDelete.value = "Clear All"
    }

    fun saveOrUpdateClick() {
        val fName = firstName.value!!
        val lName = lastName.value!!
        val  mobNo = mobileNo.value!!
        insert(User(0, fName, lName, mobNo))

        firstName.value = null
        lastName.value = null
        mobileNo.value = null
    }

    fun insert(user : User){
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    fun clearOrDeleteAll(){
        viewModelScope.launch {
            userRepository.deleteAll()
        }
    }

    val usersList = userRepository.users

}