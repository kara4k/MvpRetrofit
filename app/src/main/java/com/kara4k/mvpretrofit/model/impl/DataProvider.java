package com.kara4k.mvpretrofit.model.impl;


import com.kara4k.mvpretrofit.App;
import com.kara4k.mvpretrofit.model.DataProviderIF;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.impl.Entities.Comment;
import com.kara4k.mvpretrofit.model.impl.Entities.MenuHolder;
import com.kara4k.mvpretrofit.model.impl.Entities.Post;
import com.kara4k.mvpretrofit.model.impl.Entities.Todo;
import com.kara4k.mvpretrofit.model.impl.Entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataProvider implements DataProviderIF {

    @Override
    public void getUsers(final DataReceiver dataReceiver) {
        App.getApi().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                dataReceiver.onReceive(response.body()); // TODO: 06.09.2017 nullpointer check
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                dataReceiver.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getCategories(DataReceiver dataReceiver, Item item) {
        dataReceiver.onReceive(MenuHolder.createCategories(item.getId()));
    }

    @Override
    public void getPosts(final DataReceiver dataReceiver, final Item item) {
        App.getApi().getPosts(item.getId()).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                dataReceiver.onReceive(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                dataReceiver.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getComments(final DataReceiver dataReceiver, final Item item) {
        App.getApi().getComments(item.getId()).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                dataReceiver.onReceive(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                dataReceiver.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getTodos(final DataReceiver dataReceiver, final Item item) {
        App.getApi().getTodos(item.getId()).enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                dataReceiver.onReceive(response.body());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                dataReceiver.onError(t.getMessage());
            }
        });
    }
}
