package com.example.leagueteams.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.leagueteams.util.DataTypeConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "team_table")
public class TeamsEntity {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;

    @SerializedName("lastUpdated")
    private String lastupdated;
    @SerializedName("venue")
    private String venue;
    @SerializedName("clubColors")
    private String clubcolors;
    @SerializedName("founded")
    private int founded;
    @SerializedName("email")
    private String email;
    @SerializedName("website")
    private String website;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("crestUrl")
    private String cresturl;
    @SerializedName("tla")
    private String tla;
    @SerializedName("shortName")
    private String shortname;
    @SerializedName("name")
    private String name;

    @Embedded
    @SerializedName("area")
    private AreaEntity area;

    @ColumnInfo(name = "ListData")
    @TypeConverters(DataTypeConverter.class)
    @SerializedName("squad")
    private List<SquadEntity> squad;


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

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
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

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCresturl() {
        return cresturl;
    }

    public void setCresturl(String cresturl) {
        this.cresturl = cresturl;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }
}
