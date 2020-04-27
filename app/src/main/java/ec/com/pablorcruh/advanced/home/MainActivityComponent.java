package ec.com.pablorcruh.advanced.home;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ec.com.pablorcruh.advanced.di.ActivityScope;
import ec.com.pablorcruh.advanced.ui.NavigationModule;

@ActivityScope
@Subcomponent(modules = {
     MainScreenBindingModule.class,
        NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{

    }
}
