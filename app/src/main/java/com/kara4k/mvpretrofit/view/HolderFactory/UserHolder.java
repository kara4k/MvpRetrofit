package com.kara4k.mvpretrofit.view.HolderFactory;


import android.view.View;
import android.widget.TextView;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.impl.Entities.User;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;

public class UserHolder extends Holder {

    private final TextView mNameTextView;
    private final TextView mUsernameTextView;
    private final TextView mPhoneTextView;
    private final TextView mEmailTextView;
    private final TextView mWebsiteTextView;

    public UserHolder(View itemView, PresenterIF presenter) {
        super(itemView, presenter);
        mNameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
        mUsernameTextView = (TextView) itemView.findViewById(R.id.username_text_view);
        mPhoneTextView = (TextView) itemView.findViewById(R.id.phone_text_view);
        mWebsiteTextView = (TextView) itemView.findViewById(R.id.website_text_view);
        mEmailTextView = (TextView) itemView.findViewById(R.id.email_text_view);
    }

    @Override
    public void onBind(Item item) {
        mItem = item;
        User user = (User) item;
        mNameTextView.setText(user.getName());
        mUsernameTextView.setText(user.getUsername());
        mPhoneTextView.setText(user.getPhone());
        mWebsiteTextView.setText(user.getWebsite());
        mEmailTextView.setText(user.getEmail());
    }


}
