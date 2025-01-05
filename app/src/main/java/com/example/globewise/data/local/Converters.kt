package com.example.globewise.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromSourceEntity(source: SourceEntity): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSourceEntity(sourceString: String): SourceEntity {
        val type = object : TypeToken<SourceEntity>() {}.type
        return Gson().fromJson(sourceString, type)
    }
}