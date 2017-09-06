package com.kara4k.mvpretrofit.model.impl.Entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Shareable;
import com.kara4k.mvpretrofit.model.Type;

public class User implements Item, Shareable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("address")
    @Expose
    private Adress adress;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public boolean isParent() {
        return true;
    }

    @Override
    public int getChildType() {
        return Type.MENU_ITEM;
    }

    @Override
    public int getType() {
        return Type.USER;
    }

    @Override
    public String getShareTitle() {
        return name;
    }

    @Override
    public String getShareText() {
        return toString();
    }

    @Override
    public String getContentDesc() {
        return "Categories";
    }

    @Override
    public String toString() {
        return name + "\n"
                + username + "\n"
                + phone + "\n"
                + email + "\n"
                + website + "\n\n"
                + adress.toString();
    }
}
