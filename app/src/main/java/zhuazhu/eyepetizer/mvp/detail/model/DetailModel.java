package zhuazhu.eyepetizer.mvp.detail.model;

import javax.inject.Inject;

import zhuazhu.eyepetizer.data.net.ApiService;
import zhuazhu.eyepetizer.mvp.detail.DetailContract;

/**
 * @author zhuazhu
 **/
public class DetailModel implements DetailContract.Model {
    private final ApiService mApiService;
    @Inject
    public DetailModel(ApiService apiService) {
        mApiService = apiService;
    }
}
