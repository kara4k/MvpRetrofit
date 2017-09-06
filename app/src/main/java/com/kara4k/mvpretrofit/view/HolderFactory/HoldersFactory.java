package com.kara4k.mvpretrofit.view.HolderFactory;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Type;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;

public class HoldersFactory {

    private HoldersFactory() {
    }

    public static Holder createHolder(Context context, PresenterIF presenter, int viewType) {
        switch (viewType) {
            case Type.USER:
                View userView = LayoutInflater.from(context).inflate(R.layout.user_item, null);
                return new UserHolder(userView, presenter);
            case Type.POST:
                View postView = LayoutInflater.from(context).inflate(R.layout.post_item, null);
                return new PostHolder(postView, presenter);
            case Type.COMMENT:
                View commentView = LayoutInflater.from(context).inflate(R.layout.comment_item, null);
                return new CommentHolder(commentView, presenter);
            case Type.TODO:
                View todoView = LayoutInflater.from(context).inflate(R.layout.todo_item, null);
                return new TodoHolder(todoView, presenter);
            case Type.MENU_ITEM:
                View categoryView = LayoutInflater.from(context).inflate(R.layout.menu_item, null);
                return new MenuItemHolder(categoryView, presenter);
            default:
                return null; // TODO: 06.09.2017 empty holder
        }

    }

}
