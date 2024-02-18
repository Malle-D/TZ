package com.example.testmission.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.testmission.data.api.Api
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideClient(@ApplicationContext context:Context):OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .build()

    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl("https://skoob.ru/api/v1/app/books/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideGson(): Gson = Gson()

    @[Provides Singleton]
    fun provideApi(retrofit: Retrofit) : Api = retrofit.create(Api::class.java)

}