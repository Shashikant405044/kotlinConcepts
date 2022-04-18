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

    var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelte : User


    init {
        saveOrUpdate.value = "Save" // setting value to MutableLiveData
        clearAllOrDelete.value = "Clear All"
    }

    fun saveOrUpdateClick() {
        if (isUpdateOrDelete){
            userToUpdateOrDelte.firstName = firstName.value!!
            userToUpdateOrDelte.lastName = lastName.value!!
            userToUpdateOrDelte.mobileNo = mobileNo.value!!

            update(userToUpdateOrDelte)

            firstName.value = null
            lastName.value = null
            mobileNo.value = null

            saveOrUpdate.value = "Save"
            clearAllOrDelete.value = "Clear All"
        }else{
        val fName = firstName.value!!
        val lName = lastName.value!!
        val  mobNo = mobileNo.value!!
        insert(User(0, fName, lName, mobNo))
        firstName.value = null
        lastName.value = null
        mobileNo.value = null
        }
    }

    fun updateOrDelteteClick(user: User){
        firstName.value = user.firstName
        lastName.value = user.lastName
        mobileNo.value= user.mobileNo

        isUpdateOrDelete = true
        userToUpdateOrDelte = user

        saveOrUpdate.value = "Update"
        clearAllOrDelete.value = "Delete"

    }

    fun clearAllOrDelete(){
        if (isUpdateOrDelete){
            delete(userToUpdateOrDelte)

            firstName.value = null
            lastName.value = null
            mobileNo.value = null

            saveOrUpdate.value = "Save"
            clearAllOrDelete.value = "Clear All"
        }else{
            clearAllOrDelete()
        }
    }

    fun insert(user : User){
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    fun clearAll(){
        viewModelScope.launch {
            userRepository.deleteAll()
        }
    }

    fun update(user: User){
        viewModelScope.launch {
            userRepository.update(user)
        }
    }

    fun delete(user: User){
        viewModelScope.launch {
            userRepository.delete(user)
        }
    }

    val usersList = userRepository.users

}