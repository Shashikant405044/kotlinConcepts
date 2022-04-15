package chetu.second.batch.roomDb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import chetu.second.batch.roomDb.repository.UserRepository

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
}