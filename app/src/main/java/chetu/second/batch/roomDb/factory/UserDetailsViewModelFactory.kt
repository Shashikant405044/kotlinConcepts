package chetu.second.batch.roomDb.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import chetu.second.batch.roomDb.repository.UserRepository
import chetu.second.batch.roomDb.viewModel.UserDetailsViewModel

class UserDetailsViewModelFactory(val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailsViewModel::class.java)){
            return UserDetailsViewModel(userRepository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}