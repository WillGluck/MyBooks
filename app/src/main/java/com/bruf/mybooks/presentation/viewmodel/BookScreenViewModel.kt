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
        Book(title = "", description = "", author = "")
    )
    val book = _book.asStateFlow()

    fun loadBook(id:Int) {
        viewModelScope.launch {
            if (_book.value.id != id)
                _book.update {
                    repository.get(id)
                }
        }
    }

    fun setTile(title:String) {
        viewModelScope.launch {
            _book.update {
                it.copy(title = title)
            }
        }
    }

    fun setDescription(description:String) {
        viewModelScope.launch {
            _book.update {
                it.copy(description = description)
            }
        }
    }

    fun setAuthor(author:String) {
        viewModelScope.launch {
            _book.update {
                it.copy(author = author)
            }
        }
    }

    fun insertOrUpdateBook() {
        viewModelScope.launch {
            _book.value.run {
                if (this.id != null)
                    repository.update(this)
                else
                    repository.insert(this)
            }
        }
    }

}