package com.example.roomapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities =[User::class], version = 1, exportSchema = false)
    public abstract class MyAppDataBase : RoomDatabase() {
        abstract fun wordDao(): MyDataAccessObject

    }


