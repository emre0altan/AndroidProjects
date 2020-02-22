package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Emre Altan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView( this ,R.layout.activity_main)

        binding.myName = myName

        binding.done.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View){

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
            binding.done.visibility = View.GONE
        }

        val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
