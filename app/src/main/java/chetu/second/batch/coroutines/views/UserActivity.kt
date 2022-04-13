package chetu.second.batch.coroutines.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import chetu.second.batch.coroutines.viewModels.UserActivityViewModel
import chetu.second.batch.kotlinconcepts.R

class UserActivity : AppCompatActivity() {
    lateinit var viewModel : UserActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        viewModel = ViewModelProvider(this)[UserActivityViewModel::class.java]
        viewModel.getUserData()

        viewModel.user.observe(this, Observer { myList ->
            myList.forEach{
                Log.d("MyTag", "name is ${it.name}")
            }

        })

    }
}