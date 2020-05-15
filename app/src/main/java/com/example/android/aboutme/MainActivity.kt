package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            clickListner(it)
            findViewById<TextView>(R.id.nickname_text).setOnClickListener {
                updateNickname(it)
            }
        }
    }

    private fun clickListner(view:View){
        val ref=findViewById<EditText>(R.id.nickname_edit)
        val nickname=findViewById<TextView>(R.id.nickname_text)
        nickname.text=ref.text
        ref.visibility=View.GONE
        view.visibility=View.GONE
        nickname.visibility=View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)   //makes keyboard to vanish
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        editText.requestFocus()  //focuses keyboard on editText
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)  //makes keybord to come up
    }
}
