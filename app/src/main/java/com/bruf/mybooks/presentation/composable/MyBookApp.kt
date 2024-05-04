package com.bruf.mybooks.presentation.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bruf.mybooks.R
import com.bruf.mybooks.presentation.MyBooksScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBookApp(){

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name))},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                ),
            )
        }) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MyBooksScreen.Main.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyBooksScreen.Main.name) {
                MainScreen(
                    onAddButtonClicked = { navController.navigate(MyBooksScreen.AddBook.name) },
                    onMyBooksButtonClicked = { navController.navigate(MyBooksScreen.BookList.name) }
                )
            }
            composable(route = MyBooksScreen.BookList.name) {
                BookListScreen()
            }
            composable(route = MyBooksScreen.AddBook.name) {
                AddBookScreen()
            }


        }
    }
}