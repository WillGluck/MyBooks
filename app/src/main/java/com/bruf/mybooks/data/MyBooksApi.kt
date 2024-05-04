package com.bruf.mybooks.data

import com.bruf.mybooks.data.entity.Book
import retrofit2.http.GET

interface MyBooksApi {
    @GET("books")
    suspend fun getAll(): List<Book>
}