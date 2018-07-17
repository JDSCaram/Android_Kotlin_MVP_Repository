package com.bodeslab.architectureexamplekotlin.network.typeadapters

import android.util.Log
import com.google.gson.*
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class DateTypeAdapter : JsonSerializer<Date>, JsonDeserializer<Date> {

    val PATTERN_DATE = "yyyy-MM-dd HH:mm"
    val PATTERN_DATE_DESERIALIZE = "yyyy-MM-dd"
    val PATTERN_DATE_SERIALIZE = "yyyy-MM-dd'T'HH:mm:ss"

    override fun deserialize(json: JsonElement?, typeOfT: Type, context: JsonDeserializationContext): Date? {
        if (json != null) {
            val date = json.asString
            val dateFormat = SimpleDateFormat(PATTERN_DATE_DESERIALIZE, Locale.getDefault())
            try {
                return dateFormat.parse(date)
            } catch (e: ParseException) {
                Log.e("ParseDateError", e.message, e)
            }

        }

        return null
    }

    override fun serialize(src: Date?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement? {
        val dateFormat = SimpleDateFormat(PATTERN_DATE_SERIALIZE, Locale.getDefault())
        return if (src == null) null else JsonPrimitive(dateFormat.format(src))
    }
}