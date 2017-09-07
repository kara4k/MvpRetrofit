package com.kara4k.mvpretrofit.model.impl.Entities;


import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Type;

import java.util.ArrayList;

public class MenuCreator {

    public static ArrayList<? extends Item> createCategories(int id) {
        ArrayList<MenuItem> categories = new ArrayList<>();
        categories.add(createPostCategory(id));
        categories.add(createTodoCategory(id));
        return categories;
    }

    private static MenuItem createPostCategory(final int id) {
        MenuItem postsMenuItem = new MenuItem() {
            @Override
            public int getTypeOfChild() {
                return Type.POST;
            }

            @Override
            public String getTitle() {
                return "Posts";
            }

            @Override
            public String getContentDesc() {
                return "Posts";
            }

            @Override
            public Integer getId() {
                return id;
            }
        };
        return postsMenuItem;
    }

    private static MenuItem createTodoCategory(final int id) {
        MenuItem todoMenuItem = new MenuItem() {
            @Override
            public int getTypeOfChild() {
                return Type.TODO;
            }

            @Override
            public String getTitle() {
                return "ToDo";
            }

            @Override
            public String getContentDesc() {
                return "ToDo";
            }

            @Override
            public Integer getId() {
                return id;
            }
        };
        return todoMenuItem;
    }

}
