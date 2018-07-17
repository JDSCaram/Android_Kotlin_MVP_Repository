package com.bodeslab.architectureexamplekotlin.network.typeadapters

import android.util.Log
import com.google.gson.*
import java.lang.reflect.Type


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class LongTypeAdapter : JsonDeserializer<Long>, JsonSerializer<Long> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?,
                             context: JsonDeserializationContext?): Long? {
        return try {
            json?.asLong
        } catch (e: Exception) {
            Log.e(LongTypeAdapter::class.java.simpleName, "deserialize: ", e)
            0L
        }
    }

    override fun serialize(src: Long?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive((src ?: 0).toString())
    }
}