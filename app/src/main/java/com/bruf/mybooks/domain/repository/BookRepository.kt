package com.bruf.mybooks.domain.repository

import com.bruf.mybooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getAll(): Flow<List<Book>>

    suspend fun insert(book:Book):Unit

    suspend fun get(id:String): Book

}