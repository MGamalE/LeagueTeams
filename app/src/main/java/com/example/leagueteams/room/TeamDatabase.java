package com.example.leagueteams.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.leagueteams.model.TeamsEntity;

@Database(entities = {TeamsEntity.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase instance;

    public abstract TeamDataAccessObject teamDataAccessObject();


    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();

        }
    };

    public static TeamDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , TeamDatabase.class, "team_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        TeamDataAccessObject teamDataAccessObject;

        private PopulateDbAsyncTask(TeamDatabase db) {
            teamDataAccessObject = db.teamDataAccessObject();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }


}
