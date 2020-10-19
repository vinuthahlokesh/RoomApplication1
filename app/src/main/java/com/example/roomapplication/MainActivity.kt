package com.example.roomapplication

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var text1: EditText
    lateinit var database: MyAppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        btn1 = findViewById(R.id.button1)
        btn1 = findViewById(R.id.button1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.text)
        database = Room.databaseBuilder(this, MyAppDataBase::class.java, "users").build()

        btn1.setOnClickListener {
           addUser(text1.text.toString())

        }
        btn2.setOnClickListener{
            val intent= Intent (this,Displaylists::class.java)
            startActivity(intent)
            display()

        }
    }
    fun addUser(username: String) {
        Thread{
            val result = database.wordDao().addUser(User(username))
        }.start()

    }

    fun display()
    { Thread{
        val Listname:MutableList<User> = mutableListOf()
        Listname.addAll(database.wordDao().getUser())

        Listname.forEach{
            val name:MutableList<String> = mutableListOf()
            name.add(it.word)
        }

    }.start()
    }
}
