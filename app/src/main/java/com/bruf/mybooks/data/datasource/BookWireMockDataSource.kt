package com.bruf.mybooks.data.datasource

import com.bruf.mybooks.data.MyBooksApi
import com.bruf.mybooks.data.entity.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class BookWireMockDataSource @Inject constructor(
    private val api: MyBooksApi
): BookRemoteDatasource {
    override suspend fun getAll(): Flow<List<Book>> = flowOf(api.getAll())
}