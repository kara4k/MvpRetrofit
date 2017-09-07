package com.kara4k.mvpretrofit.modules;

import com.kara4k.mvpretrofit.model.ApiIF;
import com.kara4k.mvpretrofit.model.DataProviderIF;
import com.kara4k.mvpretrofit.model.impl.ApiProvider;
import com.kara4k.mvpretrofit.model.impl.DataProvider;
import com.kara4k.mvpretrofit.presenter.Presenter;
import com.kara4k.mvpretrofit.presenter.PresenterIF;
import com.kara4k.mvpretrofit.view.ViewIF;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    ViewIF mViewIF;

    public PresenterModule(ViewIF viewIF) {
        mViewIF = viewIF;
    }

    @Provides
    @Singleton
    PresenterIF getPresenter(DataProviderIF dataProviderIF, ViewIF viewIF) {
        return new Presenter(dataProviderIF, viewIF);
    }

    @Provides
    @Singleton
    ViewIF getViewIF() {
        return mViewIF;
    }

    @Provides
    @Singleton
    DataProviderIF getDataProvider(ApiIF apiIF) {
        return new DataProvider(apiIF);
    }

    @Provides
    @Singleton
    ApiIF getApiIf() {
        return ApiProvider.createApiIF();
    }
}
