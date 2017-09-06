package com.kara4k.mvpretrofit.model.impl.Entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Shareable;
import com.kara4k.mvpretrofit.model.Type;

public class Post implements Item, Shareable {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;

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
        return true;
    }

    @Override
    public int getChildType() {
        return Type.COMMENT;
    }

    @Override
    public int getType() {
        return Type.POST;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getContentDesc() {
        return "Comments";
    }

    @Override
    public String getShareTitle() {
        return title;
    }

    @Override
    public String getShareText() {
        return body;
    }
}
