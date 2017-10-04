package ru.strongit.game15;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 03.10.17.
 */

public class Game15App extends Application {

    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
