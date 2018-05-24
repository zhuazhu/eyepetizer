package zhuazhu.eyepetizer.di.module;

import dagger.Module;
import dagger.Provides;
import mejust.frame.di.module.BaseActivityModule;
import mejust.frame.di.scope.ActivityScope;
import zhuazhu.eyepetizer.mvp.detail.DetailContract;
import zhuazhu.eyepetizer.mvp.detail.model.DetailModel;
import zhuazhu.eyepetizer.mvp.detail.presenter.DetailPresenter;

/**
 * @author zhuazhu
 **/
@Module
public class DetailModule extends BaseActivityModule<DetailContract.View> {
    public DetailModule(DetailContract.View view) {
        super(view);
    }
    @ActivityScope
    @Provides
    public DetailContract.Presenter providesDetailPresenter(DetailContract.View view, DetailModel detailModel){
        return new DetailPresenter(view,detailModel);
    }
}
