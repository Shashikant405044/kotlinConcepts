package chetu.second.batch.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import android.view.View
import android.widget.Toast
import chetu.second.batch.kotlinconcepts.R
import chetu.second.batch.kotlinconcepts.databinding.ActivityCoroutineDemoBinding
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.*

class CoroutineDemo : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityCoroutineDemoBinding
    val myTag = "MyTag"
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDownload.setOnClickListener(this)
        binding.btnClick.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        when(view!!.id){
            R.id.btn_download ->{
                CoroutineScope(Dispatchers.IO).launch {
//                    userDownload()
//                    Log.d(myTag, "Calculation started...")
//                    val task1 = async {
//                        task1()
//                    }
//                    val task2 = async {
//                        task2()
//                    }
//
//                    val total = task1.await() + task2.await()
//                    Toast.makeText(this@CoroutineDemo, "$total", Toast.LENGTH_LONG).show()
//                    Log.d(myTag, "Total $total")
//                }
                    withContext(Dispatchers.Main){
//                        Toast.makeText(this@CoroutineDemo, "$total", Toast.LENGTH_LONG).show()
                    }
                    //
                    // TODO : calling unstructured coroutine
                    Toast.makeText(
                        this@CoroutineDemo, UserDataUnstr().getCount().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    var userData = UserDataUnstr()
                    Log.d("DATA", "DAta : ${userData.getCount()}")
                }
            }

            R.id.btn_click ->{
                binding.tvDisplay.text = count++.toString()
            }
        }
    }

   suspend fun userDownload() {
        for (i in 1..1000){
            withContext(Dispatchers.Main){
                binding.tvDisplay.text = "Downloading $i ${Thread.currentThread().name}"
            }
        }
    }


    private suspend fun task1() : Int{
        Log.d(myTag, "task 1 returned")
        delay(10000)
        return 10000
    }

    private suspend fun task2() : Int{
        Log.d(myTag, "task 2 returned")
        delay(8000)
        return 8000
    }
}