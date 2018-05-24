package zhuazhu.eyepetizer.di.component;

import dagger.Subcomponent;
import mejust.frame.di.scope.ActivityScope;
import zhuazhu.eyepetizer.di.module.DetailModule;
import zhuazhu.eyepetizer.mvp.detail.view.DetailActivity;

/**
 * @author zhuazhu
 **/
@ActivityScope
@Subcomponent(modules = DetailModule.class)
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
