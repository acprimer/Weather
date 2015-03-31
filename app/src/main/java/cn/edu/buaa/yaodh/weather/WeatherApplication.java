package cn.edu.buaa.yaodh.weather;

import android.app.Application;

import com.thinkland.sdk.android.SDKInitializer;

/**
 * Created by yaodh on 2015/3/31.
 */
public class WeatherApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
