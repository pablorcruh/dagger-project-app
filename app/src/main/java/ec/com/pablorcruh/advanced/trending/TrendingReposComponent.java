package ec.com.pablorcruh.advanced.trending;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import ec.com.pablorcruh.advanced.di.ScreenScope;

@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController>{

    }
}
