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

public class TeamEntity implements Parcelable {

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
    @SerializedName("area")
    private AreaEntity area;
    @SerializedName("squad")
    private List<SquadEntity> squad;


    public static final Creator<TeamEntity> CREATOR = new Creator<TeamEntity>() {
        @Override
        public TeamEntity createFromParcel(Parcel in) {
            return new TeamEntity(in);
        }

        @Override
        public TeamEntity[] newArray(int size) {
            return new TeamEntity[size];
        }
    };

    protected TeamEntity(Parcel in) {
        id = in.readInt();
        lastupdated = in.readString();
        venue = in.readString();
        clubcolors = in.readString();
        founded = in.readInt();
        email = in.readString();
        website = in.readString();
        phone = in.readString();
        address = in.readString();
        cresturl = in.readString();
        tla = in.readString();
        shortname = in.readString();
        name = in.readString();
    }

    public TeamEntity() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(lastupdated);
        dest.writeString(venue);
        dest.writeString(clubcolors);
        dest.writeInt(founded);
        dest.writeString(email);
        dest.writeString(website);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeString(cresturl);
        dest.writeString(tla);
        dest.writeString(shortname);
        dest.writeString(name);
    }
}
