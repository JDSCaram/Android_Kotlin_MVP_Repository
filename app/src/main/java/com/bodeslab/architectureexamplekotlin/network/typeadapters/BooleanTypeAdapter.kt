package com.bodeslab.architectureexamplekotlin.network.typeadapters

import com.google.gson.*
import java.lang.reflect.Type


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
class BooleanTypeAdapter : JsonDeserializer<Boolean>, JsonSerializer<Boolean> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Boolean? {
        return "yes".equals(json.asString, ignoreCase = true) || "1" == json.asString || json.asBoolean
    }


    override fun serialize(src: Boolean?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src != null && src)
    }
}