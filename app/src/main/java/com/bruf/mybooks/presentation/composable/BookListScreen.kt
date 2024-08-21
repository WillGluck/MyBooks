package com.bruf.mybooks.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruf.mybooks.R
import com.bruf.mybooks.domain.model.Book
import com.bruf.mybooks.presentation.viewmodel.BookListViewModel
import java.util.Collections.shuffle

@Composable
fun BookListScreen(
    modifier:Modifier = Modifier,
    bookListViewModel: BookListViewModel = hiltViewModel(),
    onBookClicked: (Book) -> Unit
) {
    val books = bookListViewModel.bookList.collectAsState().value

    Column {
        LazyColumn(
            modifier = modifier
        ) {
            items(books) { book ->
                Column(modifier = Modifier.clickable {
                    onBookClicked(book)
                }) {
                    Text(
                        text = book.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = book.author,
                        style = MaterialTheme.typography.titleSmall
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
                    )
                }
            }
        }
    }
}