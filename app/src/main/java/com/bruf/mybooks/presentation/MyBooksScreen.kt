package com.bruf.mybooks.presentation

import androidx.annotation.StringRes
import com.bruf.mybooks.R

enum class MyBooksScreen(@StringRes val title: Int) {
    Main(R.string.my_books),
    BookList(R.string.book_list),
    AddBook(R.string.add_book),
    EditBook(R.string.edit_book)

}