package com.bodeslab.architectureexamplekotlin.database.converters

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return when (value) {
            null -> null
            else -> Date(value)
        }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return when (date) {
            null -> null
            else -> date.time
        }
    }
}