package com.kara4k.mvpretrofit.view.HolderFactory;


import android.view.View;
import android.widget.TextView;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.impl.Entities.Post;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;

public class PostHolder extends Holder {

    private final TextView mTitleTextView;
    private final TextView mBodyTextView;

    public PostHolder(View itemView, PresenterIF presenter) {
        super(itemView, presenter);
        mTitleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
        mBodyTextView = (TextView) itemView.findViewById(R.id.body_text_view);
    }

    @Override
    public void onBind(Item item) {
        mItem = item;
        Post post = (Post) item;
        mTitleTextView.setText(post.getTitle());
        mBodyTextView.setText(post.getBody());
    }


}
