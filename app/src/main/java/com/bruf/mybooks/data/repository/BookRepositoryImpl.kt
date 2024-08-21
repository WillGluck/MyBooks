package com.bruf.mybooks.data.repository

import com.bruf.mybooks.data.dao.BookDao
import com.bruf.mybooks.domain.model.Book
import com.bruf.mybooks.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val dao: BookDao
): BookRepository {

    override fun getAll(): Flow<List<Book>> =
        dao.getAll().transform {
            emit(it.map { e -> Book(e.id, e.name, e.description, e.author)})
        }

    override suspend fun insert(book: Book) {
        dao.insertBook(com.bruf.mybooks.data.entity.Book(
            name = book.title, author = book.author, description = book.description
        ))
    }

    override suspend fun get(id: String): Book =
        dao.get(id).run {
            Book(this.id, name, description, author)
        }
}