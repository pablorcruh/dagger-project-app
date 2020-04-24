package ec.com.pablorcruh.advanced.base;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

import ec.com.pablorcruh.advanced.di.Injector;

public abstract class BaseController extends Controller {

    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {

        // controllers are retained we just want to inject once

        if(!injected){
            Injector.inject(this);
            injected =true;
        }

        super.onContextAvailable(context);
    }
}
