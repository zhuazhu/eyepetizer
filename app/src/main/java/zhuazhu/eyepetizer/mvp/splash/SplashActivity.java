package zhuazhu.eyepetizer.mvp.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gyf.barlibrary.BarHide;

import mejust.frame.annotation.LayoutId;
import mejust.frame.annotation.TitleBarConfig;
import mejust.frame.mvp.view.BaseActivity;
import zhuazhu.eyepetizer.R;
@LayoutId(R.layout.activity_splash)
@TitleBarConfig(textValue = "",visible = false)
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStatusBar.hideBar(BarHide.FLAG_HIDE_BAR).init();
    }
}
