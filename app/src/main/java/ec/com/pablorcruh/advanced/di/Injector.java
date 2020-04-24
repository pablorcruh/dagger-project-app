package ec.com.pablorcruh.advanced.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;

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

    public static void inject(Controller controller){
        ScreenInjector.get(controller.getActivity()).inject(controller);
    }

    public static void clearComponent(Controller controller){
        ScreenInjector.get(controller.getActivity()).clear(controller);
    }
}
