package com.kara4k.mvpretrofit.model.impl.Entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Shareable;
import com.kara4k.mvpretrofit.model.Type;

public class Todo implements Item, Shareable {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("completed")
    @Expose
    private Boolean completed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean isParent() {
        return false;
    }

    @Override
    public int getChildType() {
        return -1;
    }

    @Override
    public int getType() {
        return Type.TODO;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String getContentDesc() {
        return "";
    }


    @Override
    public String getShareTitle() {
        return "";
    }

    @Override
    public String getShareText() {
        return title;
    }
}
