package com.bodeslab.architectureexamplekotlin.di.module.application

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.bodeslab.architectureexamplekotlin.BuildConfig
import com.bodeslab.architectureexamplekotlin.network.typeadapters.BooleanTypeAdapter
import com.bodeslab.architectureexamplekotlin.network.typeadapters.DateTypeAdapter
import com.bodeslab.architectureexamplekotlin.network.typeadapters.LongTypeAdapter
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Module
class RetrofitModule(private val baseUrl: String) {
    private val HTTP_READ_TIMEOUT = 540
    private val HTTP_CONNECT_TIMEOUT = 540


    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient,
                         gsonConverterFactory: GsonConverterFactory): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideGsonConvert(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(Long::class.javaPrimitiveType, LongTypeAdapter())
                .registerTypeAdapter(Long::class.java, LongTypeAdapter())
                .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanTypeAdapter())
                .registerTypeAdapter(Boolean::class.java, BooleanTypeAdapter())
                .registerTypeAdapter(Date::class.java, DateTypeAdapter())
                .create()
    }


    @Singleton
    @Provides
    fun provideHttpInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }


    @Singleton
    @Provides
    fun provideDispatcher(): Dispatcher {
        return Dispatcher()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(dispatcher: Dispatcher,
                            logginInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClientBuilder = OkHttpClient().newBuilder()
        httpClientBuilder.connectTimeout(HTTP_CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        httpClientBuilder.readTimeout(HTTP_READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        httpClientBuilder.addInterceptor(logginInterceptor)
        httpClientBuilder.dispatcher(dispatcher)
        return httpClientBuilder.build()
    }

}