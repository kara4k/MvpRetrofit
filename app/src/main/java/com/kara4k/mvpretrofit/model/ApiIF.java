package com.kara4k.mvpretrofit.model;


import com.kara4k.mvpretrofit.model.impl.Entities.Comment;
import com.kara4k.mvpretrofit.model.impl.Entities.Post;
import com.kara4k.mvpretrofit.model.impl.Entities.Todo;
import com.kara4k.mvpretrofit.model.impl.Entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiIF {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);

    @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postId);

    @GET("todos")
    Call<List<Todo>> getTodos(@Query("userId") int userId);

}
