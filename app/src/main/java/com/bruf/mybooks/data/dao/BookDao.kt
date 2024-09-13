package com.bruf.mybooks.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bruf.mybooks.data.entity.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    fun getAll(): Flow<List<Book>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(book: Book)

    @Query("SELECT * FROM book WHERE book.id = :id")
    suspend fun get(id:Int): Book

    @Update
    suspend fun update(book:Book)
}