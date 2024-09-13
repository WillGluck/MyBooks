package com.bruf.mybooks.presentation.composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.bruf.mybooks.R
import com.bruf.mybooks.presentation.viewmodel.BookScreenViewModel

@Composable
fun BookScreen(
    modifier:Modifier = Modifier,
    viewModel: BookScreenViewModel = hiltViewModel(),
    bookId: Int? = null
) {

    bookId?.let {
        viewModel.loadBook(it)
    }

    val book = viewModel.book.collectAsState().value

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        OutlinedTextField(
            value = book.title,
            onValueChange =  viewModel::setTile,
            label = { Text(text = stringResource(R.string.title)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_small))
        )
        OutlinedTextField(
            value = book.description,
            onValueChange = viewModel::setDescription,
            label = { Text(text = stringResource(R.string.description))},
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_small))
        )
        OutlinedTextField(
            value = book.author,
            onValueChange = viewModel::setAuthor,
            label = { Text(text = stringResource(R.string.author)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_small))
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            )
             {
                Text(text = stringResource(R.string.cancel))
            }
            Spacer(
                modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_small))
            )
            Button(
                onClick = { viewModel.insertOrUpdateBook() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.save))
            }
        }
    }
}