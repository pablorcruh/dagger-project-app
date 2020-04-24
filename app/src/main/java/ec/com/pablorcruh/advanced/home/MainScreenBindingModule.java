package ec.com.pablorcruh.advanced.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import ec.com.pablorcruh.advanced.di.ControllerKey;
import ec.com.pablorcruh.advanced.trending.TrendingReposComponent;
import ec.com.pablorcruh.advanced.trending.TrendingReposController;

@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
