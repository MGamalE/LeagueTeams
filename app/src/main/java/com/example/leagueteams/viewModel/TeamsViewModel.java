package com.example.leagueteams.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.leagueteams.model.LeagueTeamsResponse;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.model.TeamEntityObject;
import com.example.leagueteams.network.RetrofitClient;
import com.example.leagueteams.util.Extras;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsViewModel extends AndroidViewModel {
    private MutableLiveData<List<TeamEntity>> teamsMutableLiveData;


    private TeamRepository teamRepository;
    private LiveData<List<TeamEntityObject>> teamsList;


    public TeamsViewModel(@NonNull Application application) {
        super(application);
        teamRepository = new TeamRepository(application);
        teamsList = teamRepository.getTeamsEntityLiveData();
    }

    public LiveData<List<TeamEntity>> getLeagueTeams() {

        if (teamsMutableLiveData == null) {
            teamsMutableLiveData = new MutableLiveData<>();
            loadTeams();
        }

        return teamsMutableLiveData;
    }

    private void loadTeams() {
        RetrofitClient.getInstance().getTeamList(Calendar.getInstance().get(Calendar.YEAR)).enqueue(new Callback<LeagueTeamsResponse>() {
            @Override
            public void onResponse(Call<LeagueTeamsResponse> call, Response<LeagueTeamsResponse> response) {

                if (response.body() != null)
                    teamsMutableLiveData.setValue(response.body().getTeams());


                insertToRoom(response.body().getTeams());
            }

            @Override
            public void onFailure(Call<LeagueTeamsResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }


    private void insertToRoom(List<TeamEntity> teams) {
        for (int i = 0; i < teams.size(); i++) {
            TeamEntityObject teamEntityObject =
                    new TeamEntityObject(teams.get(i).getId(), teams.get(i).getVenue(), teams.get(i).getClubcolors()
                            , teams.get(i).getName(), teams.get(i).getWebsite(), teams.get(i).getAddress()
                            , teams.get(i).getSquad());


            teamRepository.insert(teamEntityObject);
        }
    }

    public LiveData<List<TeamEntityObject>> getAllTeams() {
        return teamsList;
    }
}
