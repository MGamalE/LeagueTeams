package com.example.leagueteams.viewModel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.model.TeamEntityObject;
import com.example.leagueteams.room.TeamDataAccessObject;
import com.example.leagueteams.room.TeamDatabase;

import java.util.List;

public class TeamRepository {

    private TeamDataAccessObject teamDataAccessObject;
    private LiveData<List<TeamEntityObject>> teamsEntityLiveData;

    public TeamRepository(Application application) {
        TeamDatabase teamDatabase = TeamDatabase.getInstance(application);
        teamDataAccessObject = teamDatabase.teamDataAccessObject();
        teamsEntityLiveData = teamDataAccessObject.getAllTeams();

    }


    public void insert(TeamEntityObject teamEntityList) {
        new InsertAsyncTask(teamDataAccessObject).execute(teamEntityList);
    }

    public LiveData<List<TeamEntityObject>> getTeamsEntityLiveData() {
        return teamsEntityLiveData;
    }


    private static class InsertAsyncTask extends AsyncTask<TeamEntityObject, Void, Void> {
        private TeamDataAccessObject teamDataAccessObject;

        public InsertAsyncTask(TeamDataAccessObject teamDataAccessObject) {
            this.teamDataAccessObject = teamDataAccessObject;

        }

        @Override
        protected Void doInBackground(TeamEntityObject... lists) {
            teamDataAccessObject.insert(lists[0]);
            return null;
        }
    }


}
