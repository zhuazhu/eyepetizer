package zhuazhu.eyepetizer.mvp.index.model;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mejust.frame.net.FlowableUtils;
import zhuazhu.eyepetizer.app.Config;
import zhuazhu.eyepetizer.data.net.ApiService;
import zhuazhu.eyepetizer.mvp.index.IndexContract;

/**
 * @author zhuazhu
 **/
public class IndexModel implements IndexContract.Model {
    private static final int NUM = 2;
    private static final int VC = 83;
    private final ApiService mApiService;
    @Inject
    public IndexModel(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Flowable<IndexEntity> queryIndexData(boolean isFirstPage, String date) {
        Flowable<IndexEntity> flowable;
        if(isFirstPage){
            flowable = mApiService.queryFirstForIndex(NUM,Config.UUID,VC);
        }else{
            flowable = mApiService.queryMoreForIndex(NUM,date);
        }
        return flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
