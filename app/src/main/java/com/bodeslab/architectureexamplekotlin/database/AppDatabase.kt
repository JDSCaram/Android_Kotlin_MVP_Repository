package com.bodeslab.architectureexamplekotlin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.bodeslab.architectureexamplekotlin.database.converters.DateConverter
import com.bodeslab.architectureexamplekotlin.database.dao.BreedDao
import com.bodeslab.architectureexamplekotlin.database.entities.BreedEntity


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Database(entities = [(BreedEntity::class)], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}