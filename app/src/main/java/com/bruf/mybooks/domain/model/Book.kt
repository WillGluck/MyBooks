package com.bruf.mybooks.domain.model

data class Book(
    val id:Int? = null,
    var title: String,
    var description: String,
    var author: String
)
