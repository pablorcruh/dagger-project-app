package ec.com.pablorcruh.advanced.base;

import android.app.Application;

import javax.inject.Inject;

import ec.com.pablorcruh.advanced.di.ActivityInjector;

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }



    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
