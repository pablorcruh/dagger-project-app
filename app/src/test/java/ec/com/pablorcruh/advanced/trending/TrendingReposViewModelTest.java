package ec.com.pablorcruh.advanced.trending;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import ec.com.pablorcruh.advanced.R;
import ec.com.pablorcruh.advanced.data.TrendingReposResponse;
import ec.com.pablorcruh.advanced.testUtils.TestUtils;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class TrendingReposViewModelTest {

    private TrendingReposViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new TrendingReposViewModel();
    }

    @Test
    public void loading() throws Exception{
        TestObserver<Boolean> loadingObserver = viewModel.loading().test();
        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);
        loadingObserver.assertValues(true,  false);
    }


    @Test
    public void repos() throws Exception{
        TrendingReposResponse response = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
        viewModel.repoUpdated().accept(response.repos());
        viewModel.repos().test().assertValue(response.repos());
    }

    @Test
    public void error() throws Exception{
        TestObserver<Integer> errrorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.repoUpdated().accept(Collections.emptyList());
        errrorObserver.assertValues(R.string.api_error_repos, -1);
    }
}