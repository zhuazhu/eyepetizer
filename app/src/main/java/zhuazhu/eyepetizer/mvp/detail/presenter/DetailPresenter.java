package zhuazhu.eyepetizer.mvp.detail.presenter;

import android.support.annotation.NonNull;

import mejust.frame.mvp.presenter.BasePresenter;
import zhuazhu.eyepetizer.mvp.detail.DetailContract;
import zhuazhu.eyepetizer.mvp.detail.model.DetailModel;

/**
 * @author zhuazhu
 **/
public class DetailPresenter extends BasePresenter<DetailContract.View> implements DetailContract.Presenter {
    private final DetailModel mModel;

    public DetailPresenter(@NonNull DetailContract.View view, DetailModel model) {
        super(view);
        mModel = model;
    }
}
