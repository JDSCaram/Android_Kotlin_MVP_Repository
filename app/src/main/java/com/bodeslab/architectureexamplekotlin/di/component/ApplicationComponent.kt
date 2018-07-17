package com.bodeslab.architectureexamplekotlin.di.component

import android.content.Context
import com.bodeslab.architectureexamplekotlin.SampleApplication
import com.bodeslab.architectureexamplekotlin.di.module.application.*
import com.bodeslab.architectureexamplekotlin.repository.Repository
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Singleton
@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    RetrofitModule::class,
    SharedPrefsModule::class,
    RoomModule::class])
interface ApplicationComponent : AndroidInjector<SampleApplication> {
    fun inject(applicationContext: Context)
    fun provideRepositort(): Repository
}
