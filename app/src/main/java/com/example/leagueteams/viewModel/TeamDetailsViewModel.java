package com.example.leagueteams.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.leagueteams.model.SquadEntity;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailsViewModel extends AndroidViewModel {

    private TeamRepository teamRepository;
    private MutableLiveData<TeamEntity> teamMutableLiveData;
    private MutableLiveData<List<SquadEntity>> squadMutableLiveData;

    public TeamDetailsViewModel(@NonNull Application application) {
        super(application);
        teamRepository = new TeamRepository(application);

    }

    public LiveData<TeamEntity> getTeamDetails(int id) {

        if (teamMutableLiveData == null) {
            teamMutableLiveData = new MutableLiveData<>();

            loadDetails(id);
        }

        return teamMutableLiveData;
    }

    public LiveData<List<SquadEntity>> getSquad(int id) {

        if (squadMutableLiveData == null) {
            squadMutableLiveData = new MutableLiveData<>();

            loadSquad(id);
        }

        return squadMutableLiveData;
    }

    private void loadDetails(int id) {
        RetrofitClient.getInstance().getTeamDetails(id).enqueue(new Callback<TeamEntity>() {
            @Override
            public void onResponse(Call<TeamEntity> call, Response<TeamEntity> response) {
                teamMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<TeamEntity> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

    }

    private void loadSquad(int id) {
        RetrofitClient.getInstance().getTeamDetails(id).enqueue(new Callback<TeamEntity>() {
            @Override
            public void onResponse(Call<TeamEntity> call, Response<TeamEntity> response) {

                if (response.body() != null)
                    squadMutableLiveData.setValue(response.body().getSquad());
            }

            @Override
            public void onFailure(Call<TeamEntity> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

    }


}
