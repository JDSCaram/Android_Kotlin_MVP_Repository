package com.bodeslab.architectureexamplekotlin.repository.data

import retrofit2.Retrofit
import javax.inject.Inject


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class RemoteData {
    var mRetrofit: Retrofit

    @Inject
    constructor(retrofit: Retrofit) {
        this.mRetrofit = retrofit
    }

    fun getRetrofit(): Retrofit {
        return mRetrofit
    }
}