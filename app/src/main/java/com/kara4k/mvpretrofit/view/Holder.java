package com.kara4k.mvpretrofit.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.presenter.PresenterIF;


abstract public class Holder extends RecyclerView.ViewHolder
        implements View.OnClickListener, HolderViewIF{

    protected Item mItem;
    private final PresenterIF mPresenter;

    protected Holder(View itemView, PresenterIF presenter) {
        super(itemView);
        mPresenter = presenter;
        ImageView shareImageView = (ImageView) itemView.findViewById(R.id.share_image_view);
        shareImageView.setOnClickListener(this);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onItemClicked(mItem);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share_image_view:
                mPresenter.onShareClicked(mItem);
                break;
        }
    }


}
