package com.kara4k.mvpretrofit.model.impl.Entities;


import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Type;

public abstract class MenuItem implements Item {

    public abstract int getTypeOfChild();

    public abstract String getTitle();


    @Override
    public boolean isParent() {
        return true;
    }

    @Override
    public int getChildType() {
        return getTypeOfChild();
    }

    @Override
    public int getType() {
        return Type.MENU_ITEM;
    }



}
