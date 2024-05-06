package com.bruf.mybooks.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.bruf.mybooks.R


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onAddButtonClicked: () -> Unit,
    onMyBooksButtonClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(onClick = onAddButtonClicked) {
            Text(text = stringResource(id = R.string.add_book))
        }
        OutlinedButton(onClick = onMyBooksButtonClicked) {
            Text(text = stringResource(id = R.string.my_books))
        }
    }
}