package zhuazhu.eyepetizer.mvp.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.gyf.barlibrary.BarHide;

import butterknife.BindView;
import mejust.frame.annotation.LayoutId;
import mejust.frame.annotation.TitleBarConfig;
import mejust.frame.mvp.view.BaseActivity;
import zhuazhu.eyepetizer.R;
import zhuazhu.eyepetizer.mvp.main.MainActivity;

@LayoutId(R.layout.activity_splash)
@TitleBarConfig(textValue = "",visible = false)
public class SplashActivity extends BaseActivity {
    @BindView(R.id.iv_icon_splash)
    ImageView mIvIcon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStatusBar.hideBar(BarHide.FLAG_HIDE_BAR).init();
        setAnimation();
    }
    private void setAnimation(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f,1.0f);
        alphaAnimation.setDuration(1000);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f,1.0f,0.1f,1.0f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1000);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(1000);
        mIvIcon.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MainActivity.start(SplashActivity.this);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
