package zhuazhu.eyepetizer.di.component;

import dagger.Subcomponent;
import mejust.frame.di.scope.FragmentScope;
import zhuazhu.eyepetizer.di.module.IndexModule;
import zhuazhu.eyepetizer.mvp.index.view.IndexFragment;

/**
 * @author zhuazhu
 **/
@FragmentScope
@Subcomponent(modules = IndexModule.class)
public interface IndexComponent {
    void inject(IndexFragment indexFragment);
}
