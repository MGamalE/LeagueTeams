package com.example.leagueteams.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueTeamsResponse {

    @SerializedName("teams")
    private List<TeamEntity> teams;

    public List<TeamEntity> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamEntity> teams) {
        this.teams = teams;
    }
}
