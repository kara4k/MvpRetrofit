package com.kara4k.mvpretrofit.presenter;


import com.kara4k.mvpretrofit.model.Item;

public interface PresenterIF {

    void onStart();

    void onItemClicked(Item item);

    void onHomeClicked();

    void onShareClicked(Item item);



}
