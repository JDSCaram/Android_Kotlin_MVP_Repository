package com.bodeslab.architectureexamplekotlin.di.module.application

import android.app.Application
import android.arch.persistence.room.Room
import com.bodeslab.architectureexamplekotlin.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Module
class RoomModule(application: Application) {
    val DATABASE_NAME = "sample_db"

    private var mDatabase: AppDatabase

    init {
        this.mDatabase = Room.databaseBuilder(application, AppDatabase::class.java,
                DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return mDatabase
    }
}