package com.kara4k.mvpretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kara4k.mvpretrofit.view.impl.DataListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, DataListFragment.newInstance())
                .commit();
    }

}
