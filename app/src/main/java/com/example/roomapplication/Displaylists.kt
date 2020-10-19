package com.example.roomapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class Displaylists : AppCompatActivity() {
    lateinit var  database: MyAppDataBase
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        database= Room.databaseBuilder(this,MyAppDataBase::class.java,"users").build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displaylists)
        recyclerView= findViewById(R.id.recyclerview)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val list=database.wordDao().getUser()
        val listname:MutableList<String> = mutableListOf()
        list.forEach {
            listname.add(it.word)
        }
        recyclerView.adapter=RecyclerAdapter(listname)
    }
}