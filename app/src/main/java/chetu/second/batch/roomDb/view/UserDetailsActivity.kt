package chetu.second.batch.roomDb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import chetu.second.batch.kotlinconcepts.R
import chetu.second.batch.kotlinconcepts.databinding.ActivityUserDetailsBinding
import chetu.second.batch.roomDb.db.UserDatabase
import chetu.second.batch.roomDb.factory.UserDetailsViewModelFactory
import chetu.second.batch.roomDb.repository.UserRepository
import chetu.second.batch.roomDb.viewModel.UserDetailsViewModel

class UserDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)

        val dao = UserDatabase.getInstance(this).dao
        val userRepository = UserRepository(dao)
        val factory = UserDetailsViewModelFactory(userRepository)
        val userViewModel = ViewModelProvider(this, factory)[UserDetailsViewModel::class.java]

        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this



    }
}