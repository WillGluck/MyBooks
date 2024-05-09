package com.bruf.mybooks.data.datasource

import com.bruf.mybooks.data.entity.Book
import kotlinx.coroutines.flow.Flow

interface BookRemoteDatasource {
    suspend fun getAll(): Flow<List<Book>>
}