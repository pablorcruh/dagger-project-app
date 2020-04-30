package ec.com.pablorcruh.advanced.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ec.com.pablorcruh.advanced.di.Injector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class BaseController extends Controller {

    private boolean injected = false;
    private Unbinder unbinder;

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onContextAvailable(@NonNull Context context) {

        // controllers are retained we just want to inject once

        if(!injected){
            Injector.inject(this);
            injected =true;
        }

        super.onContextAvailable(context);
    }

    @NonNull
    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(layoutRes(), container,   false);
        unbinder = ButterKnife.bind(this, view);
        onViewBind(view);
        disposables.addAll(subscriptions());
        return view;
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        disposables.clear();
        if(unbinder != null){
            unbinder.unbind();
            unbinder  = null;
        }
    }

    protected void onViewBind(View view){

    }

    protected Disposable[] subscriptions(){
        return new Disposable[0];
    }

    @LayoutRes
    protected abstract int layoutRes();

}
