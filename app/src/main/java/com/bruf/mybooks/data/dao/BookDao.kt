package com.bruf.mybooks.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bruf.mybooks.data.entity.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    fun getAll(): Flow<List<Book>>

    @Insert
    suspend fun insertBook(book: Book)

    @Query("SELECT * FROM book WHERE book.id = :id")
    suspend fun get(id:String): Book
}