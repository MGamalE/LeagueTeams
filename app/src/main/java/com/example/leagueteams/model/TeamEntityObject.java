package com.example.leagueteams.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.leagueteams.util.DataTypeConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "team_table")
public class TeamEntityObject {

    @PrimaryKey()
    private int id;

    private String venue;
    private String clubcolors;
    private String name;
    private String website;
    private String address;
    @TypeConverters(DataTypeConverter.class)
    private List<SquadEntity> squad;


    public TeamEntityObject(int id, String venue, String clubcolors, String name, String website, String address, List<SquadEntity> squad) {
        this.venue = venue;
        this.id = id;
        this.clubcolors = clubcolors;
        this.name = name;
        this.website = website;
        this.address = address;
        this.squad = squad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SquadEntity> getSquad() {
        return squad;
    }

    public void setSquad(List<SquadEntity> squad) {
        this.squad = squad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getClubcolors() {
        return clubcolors;
    }

    public void setClubcolors(String clubcolors) {
        this.clubcolors = clubcolors;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
