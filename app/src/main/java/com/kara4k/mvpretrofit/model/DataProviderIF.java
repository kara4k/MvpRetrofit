package com.kara4k.mvpretrofit.model;


import java.util.List;

public interface DataProviderIF {

    interface DataReceiver {
        void onReceive(List<? extends Item> list);

        void onError(String message);
    }

    void getUsers(DataReceiver dataReceiver);

    void getCategories(DataReceiver dataReceiver, Item item);

    void getPosts(DataReceiver dataReceiver, Item item);

    void getComments(DataReceiver dataReceiver, Item item);

    void getTodos(DataReceiver dataReceiver, Item item);


}
