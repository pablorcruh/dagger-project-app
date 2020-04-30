package ec.com.pablorcruh.advanced.trending;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import ec.com.pablorcruh.advanced.R;
import ec.com.pablorcruh.advanced.base.BaseController;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class TrendingReposController extends BaseController {

    @Inject TrendingReposPresenter presenter;
    @Inject TrendingReposViewModel viewModel;


    @BindView(R.id.repo_list)
    RecyclerView repoList;
    @BindView(R.id.loading_indicator)
    View loadingView;
    @BindView(R.id.tv_error)
    TextView errorText;

    protected void onViewBind(View view){
        repoList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        repoList.setAdapter(new RepoAdapter(presenter));
    }

    protected Disposable[] subscriptions(){
        return new Disposable[]{
                viewModel.loading()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loading ->{
                    loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
                    repoList.setVisibility(loading ? View.GONE  : View.VISIBLE);
                    errorText.setVisibility(loading? View.GONE  : errorText.getVisibility());
                }),
                viewModel.repos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(((RepoAdapter)repoList.getAdapter())::setData),
                viewModel.error()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(errorRes ->{
                    if(errorRes  == -1){
                        errorText.setText(null);
                        errorText.setVisibility(View.GONE);
                    }else{
                        errorText.setVisibility(View.VISIBLE);
                        repoList.setVisibility(View.GONE);
                        errorText.setText(errorRes);
                    }
                })
        };
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_trending_repos;
    }
}
