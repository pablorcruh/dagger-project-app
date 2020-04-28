package ec.com.pablorcruh.advanced.data;

import java.util.List;

import javax.inject.Inject;

import ec.com.pablorcruh.advanced.models.Repo;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepoRequester {

    private final RepoService service;

    @Inject
    RepoRequester(RepoService service){
        this.service = service;
    }

    public Single<List<Repo>> getTrendingRepos(){
        return service.getTrendingRepos()
                .map(trendingReposResponse -> trendingReposResponse.repos())
                .subscribeOn(Schedulers.io());
    }

}
