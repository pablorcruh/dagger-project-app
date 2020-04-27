package ec.com.pablorcruh.advanced.ui;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigation(DefaultScreenNavigator screenNavigator);

}
