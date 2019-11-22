package com.example.leagueteams.model;

import com.google.gson.annotations.SerializedName;

public class SquadEntity {
    @SerializedName("role")
    private String role;
    @SerializedName("shirtNumber")
    private int shirtnumber;
    @SerializedName("nationality")
    private String nationality;
    @SerializedName("countryOfBirth")
    private String countryofbirth;
    @SerializedName("dateOfBirth")
    private String dateofbirth;
    @SerializedName("position")
    private String position;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getShirtnumber() {
        return shirtnumber;
    }

    public void setShirtnumber(int shirtnumber) {
        this.shirtnumber = shirtnumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountryofbirth() {
        return countryofbirth;
    }

    public void setCountryofbirth(String countryofbirth) {
        this.countryofbirth = countryofbirth;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

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
