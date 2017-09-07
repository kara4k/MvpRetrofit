package com.kara4k.mvpretrofit.view.impl;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kara4k.mvpretrofit.DaggerAppComponent;
import com.kara4k.mvpretrofit.R;
import com.kara4k.mvpretrofit.model.Item;
import com.kara4k.mvpretrofit.modules.PresenterModule;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.Holder;
import com.kara4k.mvpretrofit.view.HolderFactory.HoldersFactory;
import com.kara4k.mvpretrofit.view.ViewIF;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataListFragment extends Fragment implements ViewIF, DialogInterface.OnClickListener {

    @Inject
    public PresenterIF mPresenterIF;

    private ProgressDialog mProgressDialog;
    private Adapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        DaggerAppComponent.builder()
                .presenterModule(new PresenterModule(this))
                .build()
                .injectDataFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_recycler_view, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new Adapter();
        recyclerView.setAdapter(mAdapter);
        mPresenterIF.onStart();
        return recyclerView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_data_list_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_home:
                mPresenterIF.onHomeClicked();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setItems(List<? extends Item> items) {
        mAdapter.setItems(items);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setTitle(String title) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setTitle("Loading");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                getContext().getString(android.R.string.cancel), this);

        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
            mProgressDialog = null;
        }
    }

    @Override
    public void shareTo(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        hideProgressDialog();
    }

    public static DataListFragment newInstance() {
        return new DataListFragment();
    }

    class Adapter extends RecyclerView.Adapter<Holder> {

        List<? extends Item> mItems = new ArrayList<>();

        @Override
        public int getItemViewType(int position) {
            return mItems.get(position).getType();
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            Holder holder = HoldersFactory.createHolder(getContext(), mPresenterIF, viewType);
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.onBind(mItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void setItems(List<? extends Item> items) {
            mItems = items;
        }
    }


}
