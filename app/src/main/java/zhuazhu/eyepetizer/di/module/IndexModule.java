package zhuazhu.eyepetizer.di.module;

import dagger.Module;
import dagger.Provides;
import mejust.frame.di.module.BaseFragmentModule;
import mejust.frame.di.scope.FragmentScope;
import zhuazhu.eyepetizer.mvp.index.IndexContract;
import zhuazhu.eyepetizer.mvp.index.model.IndexModel;
import zhuazhu.eyepetizer.mvp.index.presenter.IndexAdapter;
import zhuazhu.eyepetizer.mvp.index.presenter.IndexPresenter;

/**
 * @author zhuazhu
 **/
@Module
public class IndexModule extends BaseFragmentModule<IndexContract.View> {
    public IndexModule(IndexContract.View view) {
        super(view);
    }
    @FragmentScope
    @Provides
    public IndexContract.Presenter providesIndexPresenter(IndexContract.View view, IndexModel indexModel,IndexAdapter indexAdapter){
        return new IndexPresenter(view,indexModel,indexAdapter);
    }
    @FragmentScope
    @Provides
    public IndexAdapter providesIndexAdapter(){
        return new IndexAdapter();
    }
}
