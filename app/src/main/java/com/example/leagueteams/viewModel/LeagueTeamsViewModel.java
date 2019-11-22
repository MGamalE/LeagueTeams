package com.example.leagueteams.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.leagueteams.model.LeagueTeamsResponse;
import com.example.leagueteams.model.TeamsEntity;
import com.example.leagueteams.network.RetrofitClient;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeagueTeamsViewModel extends AndroidViewModel {

    MutableLiveData<List<TeamsEntity>> teamsMutableLiveData;

    public LeagueTeamsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<TeamsEntity>> getLeagueTeams() {

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
                teamsMutableLiveData.setValue(response.body().getTeams());
            }

            @Override
            public void onFailure(Call<LeagueTeamsResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }


}
