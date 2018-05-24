package zhuazhu.eyepetizer.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import conm.zhuazhu.common.utils.Utils;
import mejust.frame.annotation.TitleBarMenuLocation;
import mejust.frame.app.AppConfig;
import mejust.frame.app.ConfigInterface;
import mejust.frame.di.module.AppModule;
import mejust.frame.widget.title.TitleBarSetting;
import zhuazhu.eyepetizer.BuildConfig;
import zhuazhu.eyepetizer.R;
import zhuazhu.eyepetizer.di.component.AppComponent;
import zhuazhu.eyepetizer.di.component.DaggerAppComponent;
import zhuazhu.eyepetizer.di.module.DataModule;

/**
 * @author zhuazhu
 **/
public class EyeApp extends Application implements ConfigInterface{

    @Override
    public void onCreate() {
        super.onCreate();
        AppConfig.init(this,this);
    }
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(Utils.getApp()))
                    .dataModule(new DataModule())
                    .build();
        }
        return appComponent;
    }

    @Override
    public boolean isAppDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Class<? extends Activity> getLoginActivityClass() {
        return null;
    }

    @Override
    public TitleBarSetting getTitleBarSetting() {
        Context context = getApplicationContext();
        TitleBarSetting.TitleMenu titleMenu = new TitleBarSetting.TitleMenu(TitleBarMenuLocation.leftFirstMenu);
        titleMenu.setIconDrawableRes(context, R.drawable.contact_author);
        titleMenu.setClickListener(v -> {
            /**
             * 关闭最顶部的activity
             */
            Activity activity = Utils.getTopActivity();
            if (activity!=null) {
                activity.finish();
            }
        });
        TitleBarSetting titleBarSetting = new TitleBarSetting.Builder()
                .addTitleMenu(titleMenu)
                .build();
        return titleBarSetting;
    }
}
