package com.kara4k.mvpretrofit.model.impl.Entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Shareable;
import com.kara4k.mvpretrofit.model.Type;

public class Comment implements Item, Shareable {

    @SerializedName("postId")
    @Expose
    private Integer postId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("body")
    @Expose
    private String body;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
        return Type.COMMENT;
    }

    @Override
    public String getContentDesc() {
        return "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getShareTitle() {
        return name;
    }

    @Override
    public String getShareText() {
        return body;
    }
}
