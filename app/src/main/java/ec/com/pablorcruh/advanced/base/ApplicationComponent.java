package ec.com.pablorcruh.advanced.base;

import javax.inject.Singleton;

import dagger.Component;
import ec.com.pablorcruh.advanced.data.RepoServiceModule;
import ec.com.pablorcruh.advanced.networking.ServiceModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
