package com.bruf.mybooks

import android.content.Context
import androidx.room.Room
import com.bruf.mybooks.data.MyBooksApi
import com.bruf.mybooks.data.MyBooksDatabase
import com.bruf.mybooks.data.dao.BookDao
import com.bruf.mybooks.data.repository.BookRepositoryImpl
import com.bruf.mybooks.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMyBooksApi(): MyBooksApi {
        return Retrofit.Builder()
            .baseUrl("https://wy1j9.wiremockapi.cloud/")
            .build()
            .create(MyBooksApi::class.java)
    }

    @Provides
    fun providesMyBooksDatabase(@ApplicationContext context: Context): MyBooksDatabase {
        return Room.databaseBuilder(
            context,
            MyBooksDatabase::class.java,
            "my_books_database"
        ).build()
    }

    @Provides
    fun providesBookDao(database: MyBooksDatabase):BookDao {
        return database.getBookDao()
    }

    @Provides
    fun provideBookRepository(bookDao: BookDao): BookRepository {
        return BookRepositoryImpl(bookDao)
    }

}
