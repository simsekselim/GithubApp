package com.selimsimsek.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.selimsimsek.data.local.local_dto.OwnerDb

class Converter {

    @TypeConverter
    fun ownerToString(owner: OwnerDb): String {
        return Gson().toJson(owner)
    }

    @TypeConverter
    fun stringToOwner(owner: String): OwnerDb {
        return Gson().fromJson(owner, OwnerDb::class.java)
    }

}