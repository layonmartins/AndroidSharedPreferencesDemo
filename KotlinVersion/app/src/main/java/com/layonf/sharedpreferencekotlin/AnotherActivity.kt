package com.layonf.sharedpreferencekotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_another.*

class AnotherActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("NAME", "")
        nametview.text = name

        val age = sharedPreferences.getInt("AGE", 0)
        ageTview.text = "" + age

        logoutBt.setOnClickListener{
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}