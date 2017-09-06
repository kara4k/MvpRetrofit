package com.kara4k.mvpretrofit.model;


public interface Item {

    Integer getId();

    boolean isParent();

    int getChildType();

    int getType();

    String getContentDesc();
}
