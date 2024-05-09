package com.bruf.mybooks.data.datasource

import com.bruf.mybooks.data.entity.Book
import com.bruf.mybooks.domain.core.Result
import kotlinx.coroutines.flow.Flow

interface BookLocalDatasource {

    fun getAll(): Flow<List<Book>>

    suspend fun insert(book: Book)
}