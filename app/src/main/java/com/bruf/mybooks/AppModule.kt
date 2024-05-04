package com.bruf.mybooks

import com.bruf.mybooks.data.MyBooksApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    fun provideMyBooksApi(): MyBooksApi {
        return Retrofit.Builder()
            .baseUrl("https://wy1j9.wiremockapi.cloud/")
            .build()
            .create(MyBooksApi::class.java)
    }




}
