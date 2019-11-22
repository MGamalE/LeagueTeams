package com.example.leagueteams.model;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class AreaEntity {
    @ColumnInfo(name = "area_name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "area_id")
    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
