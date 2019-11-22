package com.example.leagueteams.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.leagueteams.model.TeamsEntity;

import java.util.List;

@Dao
public interface TeamDataAccessObject {


    @Insert
    void insert(TeamsEntity teamsEntity);

    @Delete
    void delete(TeamsEntity teamsEntity);


    @Query("SELECT * FROM team_table")
    LiveData<List<TeamsEntity>> getAllTeams();
}
