package com.kara4k.mvpretrofit.model.impl.Entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Adress {
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("suite")
    @Expose
    private String suite;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address: " + "\n" +
                "Street: " + street + "\n"
                + "Suite: " + suite + "\n"
                + "City: " + city + "\n"
                + "Zip: " + zipcode;
    }
}
