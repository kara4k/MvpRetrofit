package com.kara4k.mvpretrofit.view;


import android.content.Intent;

import com.kara4k.mvpretrofit.model.Item;

import java.util.List;

public interface ViewIF {
    void setItems(List<? extends Item> items);

    void showErrorMessage(String message);

    void setTitle(String title);

    void showProgressDialog();

    void hideProgressDialog();

    void shareTo(Intent intent);

}
