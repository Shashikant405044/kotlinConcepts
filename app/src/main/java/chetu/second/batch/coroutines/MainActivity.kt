package chetu.second.batch.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import chetu.second.batch.kotlinconcepts.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnDownload : MaterialButton
    lateinit var btnClick : MaterialButton
    lateinit var tvDisplay : MaterialTextView
    var count : Int = 0

    //https://github.com/Kotlin/kotlinx.coroutines

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnDownload = findViewById(R.id.btn_download)
        btnClick = findViewById(R.id.btn_click)
        tvDisplay = findViewById(R.id.tv_display)

        btnDownload.setOnClickListener(this)
        btnClick.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        when(view!!.id){
            R.id.btn_download ->{

                // Define Coroutine scope
                // Coroutine status
                // Couroutine Builder

                CoroutineScope(Dispatchers.IO).launch {

                    for (i in 1L..20000L){
//                            Log.d("Downloading", "Downloading $i {${Thread.currentThread().name}}")
                        withContext(Dispatchers.Main){
                            tvDisplay.text = "Downloading $i {${Thread.currentThread().name}}"
                        }

                    }

                }

            }
            R.id.btn_click ->{
                tvDisplay.text = count++.toString()
            }
        }
    }
}