package com.example.heroapp.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separater = ","

    @TypeConverter
    fun listOfStringToString(list: List<String>):String{
        val stringBuilder = StringBuilder()
        for (item in list){
            stringBuilder.append(item).append(separater)
        }
        stringBuilder.setLength(stringBuilder.length-separater.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun stringToListOfString(string: String):List<String>{
        return string.split(separater)
    }

}