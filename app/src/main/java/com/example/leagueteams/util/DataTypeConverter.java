package com.example.leagueteams.util;

import android.arch.persistence.room.TypeConverter;

import com.example.leagueteams.model.SquadEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class DataTypeConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<SquadEntity> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<SquadEntity>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<SquadEntity> someObjects) {
        return gson.toJson(someObjects);
    }
}