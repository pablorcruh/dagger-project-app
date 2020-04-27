package ec.com.pablorcruh.advanced.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bluelinelabs.conductor.Controller;

import ec.com.pablorcruh.advanced.R;
import ec.com.pablorcruh.advanced.base.BaseActivity;
import ec.com.pablorcruh.advanced.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
