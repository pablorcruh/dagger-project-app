package ec.com.pablorcruh.advanced.trending;

import javax.inject.Inject;

import ec.com.pablorcruh.advanced.data.RepoRequester;
import ec.com.pablorcruh.advanced.models.Repo;

public class TrendingReposPresenter implements  RepoAdapter.RepoClickedListener{

    private final TrendingReposViewModel viewModel;
    private final RepoRequester repoRequester;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRequester repoRequester){
        this.viewModel = viewModel;
        this.repoRequester = repoRequester;
        loadRepos();
    }

    private void loadRepos() {
        repoRequester.getTrendingRepos()
                .doOnSubscribe( __ ->viewModel.loadingUpdated().accept(true))
                .doOnEvent((d,t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.repoUpdated(), viewModel.onError());
    }


    @Override
    public void onRepoClicked(Repo repo) {

    }
}
