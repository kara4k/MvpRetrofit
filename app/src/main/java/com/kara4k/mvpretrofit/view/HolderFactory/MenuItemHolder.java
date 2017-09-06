package com.kara4k.mvpretrofit.view.HolderFactory;


import android.view.View;
import android.widget.TextView;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.impl.Entities.MenuItem;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;

public class MenuItemHolder extends Holder {

    private final TextView mTitleTextView;

    public MenuItemHolder(View itemView, PresenterIF presenter) {
        super(itemView, presenter);
        mTitleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
    }

    @Override
    public void onBind(Item item) {
        mItem = item;
        MenuItem menuItem = (MenuItem) item;
        mTitleTextView.setText(menuItem.getTitle());
    }
}
