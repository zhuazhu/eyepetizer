package zhuazhu.eyepetizer.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mejust.frame.net.HttpConfigHelper;
import okhttp3.OkHttpClient;
import zhuazhu.eyepetizer.data.net.ApiService;

/**
 * @author zhuazhu
 **/
@Module
public class DataModule {
    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient(HttpConfigHelper httpConfigHelper) {
        return httpConfigHelper.buildDefaultOkHttpClientBuilder()
//                .addInterceptor(new ParamInterceptor())
                .addInterceptor(httpConfigHelper.createHttpLogInterceptor())
                .build();
    }
    @Singleton
    @Provides
    public ApiService providesApiService(HttpConfigHelper httpConfigHelper, OkHttpClient
            okHttpClient){
        return httpConfigHelper.createApi(ApiService.class,okHttpClient);
    }
}
