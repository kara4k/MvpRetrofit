package com.kara4k.mvpretrofit;

import com.kara4k.mvpretrofit.modules.PresenterModule;
import com.kara4k.mvpretrofit.view.impl.DataListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {PresenterModule.class})
@Singleton
public interface AppComponent {

    void injectDataFragment(DataListFragment fragment);

}
