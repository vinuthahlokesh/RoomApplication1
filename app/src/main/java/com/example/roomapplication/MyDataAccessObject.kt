package com.example.roomapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDataAccessObject {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addUser(word: User)

    @Query("SELECT * FROM User")
    fun getUser() : List<User>
}