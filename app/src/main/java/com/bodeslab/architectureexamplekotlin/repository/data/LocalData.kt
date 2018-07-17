package com.bodeslab.architectureexamplekotlin.repository.data

import android.content.SharedPreferences
import com.bodeslab.architectureexamplekotlin.database.AppDatabase
import javax.inject.Inject


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class LocalData() {

    private lateinit var mDatabase: AppDatabase
    private lateinit var mPrefs: SharedPreferences

    @Inject
    constructor(database: AppDatabase, prefs: SharedPreferences) : this() {
        this.mDatabase = database
        this.mPrefs = prefs
    }

    fun getDatabase(): AppDatabase {
        return mDatabase
    }

    fun getPrefs(): SharedPreferences {
        return mPrefs
    }

}