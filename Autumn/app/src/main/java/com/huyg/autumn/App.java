package com.huyg.autumn;

import android.app.Application;

/**
 * Created by huyg on 2019-10-09.
 */
public class App extends Application {

    private static App mApp;

    public static App getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
}
