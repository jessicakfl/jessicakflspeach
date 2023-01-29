package com.example.jessicakflspeach

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import java.util.Locale
import kotlinx.android.synthetic.main.activity_kfl_speach.*
class KflSpeachActivity : AppCompatActivity() {
    private val CODE=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kfl_speach)
//        val imageButton:ImageButton= ImageButton(applicationContext)

        imageButton.setOnClickListener { Toast.makeText(this,"test", Toast.LENGTH_SHORT).show()
            speech()
        }
//        makeText(applicationContext,"Hello Javatpoint", LENGTH_SHORT).show()
    }

    private fun speech(){
val sIntent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        sIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        sIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        sIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "SAY SOMETHING")
//        try{
//    startActivityForResult(sIntent,CODE)
//            Log.d("CODE", ",CODE,$CODE")
//        }catch(e:Exception){
//            Toast.makeText(this,e.message, Toast.LENGTH_SHORT).show()
//            Log.d("test", e.message.toString())
//        }
        getResult.launch(sIntent)
    }
private val getResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    if(it.resultCode==Activity.RESULT_OK){
        textView.text=it.data?.getStringExtra("input")
        Toast.makeText(this,it.data?.getStringExtra("input"), Toast.LENGTH_SHORT).show()
    }
}
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when(resultCode){
//            CODE->{
//                if(resultCode==Activity.RESULT_OK&&null!=data){
//                    var result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                    textView.text= result?.get(0) ?: "SOMETHING"
//                }
//            }
//        }
//    }
}