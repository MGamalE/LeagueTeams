package com.example.leagueteams.network;

import com.example.leagueteams.model.LeagueTeamsResponse;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.util.ServiceRoutes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET(ServiceRoutes.LEAGUE_TEAMS)
    Call<LeagueTeamsResponse> getLeagueTeamList(@Path("id") int id);

    @GET(ServiceRoutes.TEAM)
    Call<TeamEntity> getTeamDetails(@Path("id") int id);
}
