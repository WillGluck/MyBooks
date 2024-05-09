package com.bruf.mybooks.data.datasource

import com.bruf.mybooks.data.dao.BookDao
import com.bruf.mybooks.data.entity.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookRoomDataSource @Inject constructor(
    private val dao: BookDao
): BookLocalDatasource {

    override fun getAll(): Flow<List<Book>> = dao.getAll()


    override suspend fun insert(book: Book) = dao.insertBook(book)

}