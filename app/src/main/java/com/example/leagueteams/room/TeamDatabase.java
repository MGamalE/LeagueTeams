package com.example.leagueteams.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.model.TeamEntityObject;

@Database(entities = {TeamEntityObject.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase instance;

    public abstract TeamDataAccessObject teamDataAccessObject();


    public static TeamDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , TeamDatabase.class, "team_database")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }


}
