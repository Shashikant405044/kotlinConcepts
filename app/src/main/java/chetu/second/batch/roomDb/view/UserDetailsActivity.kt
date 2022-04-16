package chetu.second.batch.roomDb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import chetu.second.batch.kotlinconcepts.R
import chetu.second.batch.kotlinconcepts.databinding.ActivityUserDetailsBinding
import chetu.second.batch.roomDb.MyRecyclerViewAdapter
import chetu.second.batch.roomDb.db.UserDatabase
import chetu.second.batch.roomDb.factory.UserDetailsViewModelFactory
import chetu.second.batch.roomDb.repository.UserRepository
import chetu.second.batch.roomDb.viewModel.UserDetailsViewModel

class UserDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityUserDetailsBinding
    lateinit var userViewModel : UserDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)
        binding.userRecyclerview.layoutManager = LinearLayoutManager(this)

        val dao = UserDatabase.getInstance(this).dao
        val userRepository = UserRepository(dao)
        val factory = UserDetailsViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, factory)[UserDetailsViewModel::class.java]

        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this

        displayUsersList()

    }

    fun displayUsersList(){
        userViewModel.usersList.observe(this, Observer {
            binding.userRecyclerview.adapter = MyRecyclerViewAdapter(it)
        })
    }
}