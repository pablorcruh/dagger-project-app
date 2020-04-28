package ec.com.pablorcruh.advanced.networking;

import com.squareup.moshi.Moshi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ec.com.pablorcruh.advanced.NetworkModule;
import ec.com.pablorcruh.advanced.models.AdapterFactory;
import ec.com.pablorcruh.advanced.models.ZoneDateTimeAdapter;
import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module(includes = NetworkModule.class)
public abstract class ServiceModule {
    @Provides
    @Singleton
    static Moshi proovideMoshi(){
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZoneDateTimeAdapter())
                .build();
    }

   @Provides
   @Singleton
   static Retrofit provideRetrofit(Moshi moshi, Call.Factory callFactory, @Named("base_url") String baseUrl){
        return new Retrofit.Builder()
                .callFactory(callFactory)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
   }


}
