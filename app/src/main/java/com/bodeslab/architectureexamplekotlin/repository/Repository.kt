package com.bodeslab.architectureexamplekotlin.repository

import com.bodeslab.architectureexamplekotlin.repository.data.LocalData
import com.bodeslab.architectureexamplekotlin.repository.data.RemoteData


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
interface Repository {
    fun local(): LocalData?
    fun remote(): RemoteData?
}