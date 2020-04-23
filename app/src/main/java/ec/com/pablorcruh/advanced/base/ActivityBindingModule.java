package ec.com.pablorcruh.advanced.base;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import ec.com.pablorcruh.advanced.home.MainActivity;
import ec.com.pablorcruh.advanced.home.MainActivityComponent;

@Module(subcomponents = {
        MainActivityComponent.class
})
public abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);
}
