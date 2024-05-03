package com.bruf.mybooks.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val name: String,
    val author: String,
    val description: String
)
