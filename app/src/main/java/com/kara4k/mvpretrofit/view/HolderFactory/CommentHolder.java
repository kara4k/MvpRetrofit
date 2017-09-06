package com.kara4k.mvpretrofit.view.HolderFactory;


import android.view.View;
import android.widget.TextView;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.impl.Entities.Comment;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;

public class CommentHolder extends Holder {

    private final TextView mNameTextView;
    private final TextView mEmailTextView;
    private final TextView mBodyTextView;

    public CommentHolder(View itemView, PresenterIF presenter) {
        super(itemView, presenter);
        mNameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
        mEmailTextView = (TextView) itemView.findViewById(R.id.email_text_view);
        mBodyTextView = (TextView) itemView.findViewById(R.id.body_text_view);
    }

    @Override
    public void onBind(Item item) {
        mItem = item;
        Comment comment = (Comment) item;
        mNameTextView.setText(comment.getName());
        mEmailTextView.setText(comment.getEmail());
        mBodyTextView.setText(comment.getBody());
    }


}
