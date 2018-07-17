package com.bodeslab.architectureexamplekotlin

import android.app.Application
import com.bodeslab.architectureexamplekotlin.di.component.ApplicationComponent
import com.bodeslab.architectureexamplekotlin.di.component.DaggerApplicationComponent
import com.bodeslab.architectureexamplekotlin.di.module.application.RetrofitModule
import com.bodeslab.architectureexamplekotlin.di.module.application.RoomModule
import com.bodeslab.architectureexamplekotlin.di.module.application.SharedPrefsModule


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class SampleApplication : Application() {


    companion object {
        @JvmStatic
        lateinit var daggerComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        daggerComponent = DaggerApplicationComponent.builder()
                .roomModule(RoomModule(this))
                .retrofitModule(RetrofitModule(BuildConfig.BASE_URL))
                .sharedPrefsModule(SharedPrefsModule(this))
                .build()
        daggerComponent.inject(this)
    }
}