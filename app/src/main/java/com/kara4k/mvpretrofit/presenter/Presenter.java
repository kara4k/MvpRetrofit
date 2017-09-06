package com.kara4k.mvpretrofit.presenter;


import android.content.Intent;

import com.kara4k.mvpretrofit.model.DataProviderIF;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.model.Shareable;
import com.kara4k.mvpretrofit.model.Type;
import com.kara4k.mvpretrofit.view.ViewIF;

import java.util.List;

public class Presenter implements PresenterIF, DataProviderIF.DataReceiver {

    private final DataProviderIF mDataProviderIF;
    private final ViewIF mViewIF;

    public Presenter(DataProviderIF dataProviderIF, ViewIF viewIF) {
        mDataProviderIF = dataProviderIF;
        mViewIF = viewIF;
    }

    public void onStart() {
        mViewIF.setTitle("Users"); // TODO: 06.09.2017 extract xml
        mViewIF.showProgressDialog();
        mDataProviderIF.getUsers(this);
    }

    @Override
    public void onItemClicked(Item item) {
        if (item.isParent()) {
            mViewIF.setTitle(item.getContentDesc());
            mViewIF.showProgressDialog();
            int childType = item.getChildType();
            switch (childType) {
                case Type.USER:
                    mDataProviderIF.getUsers(this);
                    break;
                case Type.MENU_ITEM:
                    mDataProviderIF.getCategories(this, item);
                    break;
                case Type.POST:
                    mDataProviderIF.getPosts(this, item);
                    break;
                case Type.COMMENT:
                    mDataProviderIF.getComments(this, item);
                    break;
                case Type.TODO:
                    mDataProviderIF.getTodos(this, item);
                    break;
            }
        }
    }

    @Override
    public void onHomeClicked() {
        onStart();
    }

    @Override
    public void onShareClicked(Item item) {
        if (item instanceof Shareable) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, ((Shareable) item).getShareTitle());
            intent.putExtra(Intent.EXTRA_TEXT, ((Shareable) item).getShareText());
            mViewIF.shareTo(intent);
        }
    }

    @Override
    public void onReceive(List<? extends Item> list) {
        mViewIF.setItems(list);
        mViewIF.hideProgressDialog();
    }

    @Override
    public void onError(String message) {
        mViewIF.showErrorMessage(message);
    }

}
