package zhuazhu.eyepetizer.di.component;

import javax.inject.Singleton;

import dagger.Component;
import mejust.frame.di.module.AppModule;
import zhuazhu.eyepetizer.di.module.DataModule;
import zhuazhu.eyepetizer.di.module.DetailModule;
import zhuazhu.eyepetizer.di.module.IndexModule;

/**
 * @author zhuazhu
 **/
@Singleton
@Component(modules = {DataModule.class, AppModule.class})
public interface AppComponent {
    IndexComponent indexComponent(IndexModule indexModule);

    DetailComponent detailComponent(DetailModule detailModule);
}
