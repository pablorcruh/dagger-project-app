package ec.com.pablorcruh.advanced.di;

import android.app.Activity;

import autovalue.shaded.com.google$.common.collect.$AbstractIterator;
import ec.com.pablorcruh.advanced.base.BaseActivity;

public class Injector {

    private Injector(){

    }

    public static void inject(Activity activity){
        ActivityInjector.get(activity).inject(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }
}
