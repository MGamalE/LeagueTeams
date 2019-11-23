package com.example.leagueteams.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.model.TeamEntityObject;

import java.util.List;

@Dao
public interface TeamDataAccessObject {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TeamEntityObject teamEntity);

    @Delete
    void delete(TeamEntityObject teamEntity);


    @Query("SELECT * FROM team_table")
    LiveData<List<TeamEntityObject>> getAllTeams();

}
