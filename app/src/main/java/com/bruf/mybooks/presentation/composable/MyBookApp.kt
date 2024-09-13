package com.bruf.mybooks.presentation.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bruf.mybooks.R
import com.bruf.mybooks.domain.model.Book
import com.bruf.mybooks.presentation.enums.MyBooksScreen
import kotlin.random.Random

@Composable
fun MyBookApp(){

    val navController = rememberNavController()
    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyBooksScreen.valueOf(
        backstackEntry?.destination?.route?.split("/")?.get(0)
            ?: MyBooksScreen.Main.name
    )
    val mockBooks = mutableListOf<Book>()
    val text = "abcdefghijklmnopqrstuvxz"
    repeat(10) {
        mockBooks.add(
            Book(
                Random.nextInt(),
                String(text.toByteArray().apply {shuffle()}),
                String(text.toByteArray().apply {shuffle()}),
                String(text.toByteArray().apply {shuffle()})
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyBookAppTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                onNavigateBack = { navController.popBackStack() }
            )
        }) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MyBooksScreen.Main.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MyBooksScreen.Main.name) {
                MainScreen(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                        .fillMaxSize(),
                    onAddButtonClicked = { navController.navigate(MyBooksScreen.AddBook.name) },
                    onMyBooksButtonClicked = { navController.navigate(MyBooksScreen.BookList.name) }
                )
            }
            composable(route = MyBooksScreen.BookList.name) {
                BookListScreen(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                        .fillMaxSize(),
                    onBookClicked = {
                        navController.navigate("${MyBooksScreen.EditBook.name}/${it.id}")
                    }
                )
            }
            composable(route = MyBooksScreen.AddBook.name) {
                BookScreen(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                        .fillMaxSize()
                )
            }
            val bookIdKey = "bookId"
            composable(
                route = "${MyBooksScreen.EditBook.name}/{$bookIdKey}",
                arguments = listOf(navArgument(bookIdKey) { type = NavType.IntType })
            ) {
                BookScreen(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                        .fillMaxSize(),
                    bookId = it.arguments?.getInt(bookIdKey)
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBookAppTopBar(
    currentScreen: MyBooksScreen,
    canNavigateBack: Boolean,
    onNavigateBack: () -> Unit,
    modifier:Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(stringResource(id = currentScreen.title))},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(
                    onClick = onNavigateBack
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}