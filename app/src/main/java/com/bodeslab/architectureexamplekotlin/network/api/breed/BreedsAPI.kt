package com.bodeslab.architectureexamplekotlin.network.api.breed

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * {Created by Jonatas Caram on 25/05/2018}.
 */
interface BreedsAPI {

    @Headers("Content-type: application/json")

    @GET("/breeds")
    fun getBreeds(): Observable<BreedsResponse>

    @GET("/breeds")
    fun getBreedsPerPage(@Query("page") number: String): Observable<BreedsResponse>

}