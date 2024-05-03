package com.bruf.mybooks.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bruf.mybooks.data.entity.Book
import kotlinx.coroutines.flow.Flow

interface BookDao {

    @Query("SELECT * FROM book")
    fun getAll(): Flow<List<Book>>

    @Query("SELECT * FROM book WHERE id = :id")
    fun get(id:String): Book

    @Insert
    fun insertBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

}