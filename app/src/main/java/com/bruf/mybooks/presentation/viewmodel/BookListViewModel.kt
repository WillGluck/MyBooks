package com.bruf.mybooks.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bruf.mybooks.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val repository: BookRepository
): ViewModel() {

    val bookList = repository.getAll()
        .catch { Log.e("Tag", "Message", it) }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

}