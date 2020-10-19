package com.example.roomapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(@PrimaryKey @ColumnInfo(name = "username") val word: String) {


}