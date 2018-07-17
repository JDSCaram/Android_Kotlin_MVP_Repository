package com.bodeslab.architectureexamplekotlin.di.module.application

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Module
class SharedPrefsModule(application: Application) {
    private var mPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

    @Provides
    @Singleton
    fun provideSharedPrefs(): SharedPreferences {
        return mPrefs
    }
}