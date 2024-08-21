package com.bruf.mybooks.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bruf.mybooks.domain.model.Book
import com.bruf.mybooks.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookScreenViewModel @Inject constructor(
    private val repository: BookRepository
):ViewModel() {

    private var _book = MutableStateFlow(
        Book(title = "asd", description = "asd", author = "asd")
    )
    var book = _book.asStateFlow()

    fun loadBook(id:String) {
        viewModelScope.launch {
            _book.update {
                repository.get(id)
            }
        }
    }

    fun insertBook() {
        viewModelScope.launch {
            repository.insert(_book.value)
        }
    }

}