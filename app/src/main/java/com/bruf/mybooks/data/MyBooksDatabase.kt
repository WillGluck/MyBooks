package com.bruf.mybooks.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bruf.mybooks.data.dao.BookDao
import com.bruf.mybooks.data.entity.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class MyBooksDatabase: RoomDatabase() {
    abstract fun getBookDao(): BookDao
}