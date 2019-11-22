package com.example.leagueteams.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueTeamsResponse {

    @SerializedName("teams")
    private List<TeamsEntity> teams;

    public List<TeamsEntity> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsEntity> teams) {
        this.teams = teams;
    }
}
