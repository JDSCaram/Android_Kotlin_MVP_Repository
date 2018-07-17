package com.bodeslab.architectureexamplekotlin.di.module.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Module
class ApplicationModule(private val context: Application) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}