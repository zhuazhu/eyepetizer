package zhuazhu.eyepetizer.mvp.detail.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.danikula.videocache.HttpProxyCacheServer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;

import java.io.File;

import butterknife.BindView;
import conm.zhuazhu.common.utils.ScreenUtils;
import mejust.frame.annotation.LayoutId;
import mejust.frame.annotation.TitleBarConfig;
import mejust.frame.mvp.view.BasePresenterActivity;
import zhuazhu.eyepetizer.R;
import zhuazhu.eyepetizer.app.EyeApp;
import zhuazhu.eyepetizer.di.module.DetailModule;
import zhuazhu.eyepetizer.mvp.detail.DetailContract;

/**
 * @author zhuazhu
 **/
@LayoutId(R.layout.activity_detail)
@TitleBarConfig(textValue = "",visible = false)
public class DetailActivity extends BasePresenterActivity<DetailContract.Presenter> implements DetailContract.View {
    private static final String URL_KEY = "url";
    public static void start(Context context,String url){
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra(URL_KEY,url);
        context.startActivity(intent);
    }
    @BindView(R.id.player)
    StandardGSYVideoPlayer mVideoPlayer;
    private String mUrl;
    @Override
    protected void initParam() {
        mUrl = getIntent().getStringExtra(URL_KEY);
    }

    @Override
    protected void injectComponent() {
        EyeApp.getAppComponent().detailComponent(new DetailModule(this)).inject(this);
    }

    @Override
    protected void initView() {
        mVideoPlayer.getBackButton().setVisibility(View.GONE);
        mVideoPlayer.getTitleTextView().setVisibility(View.GONE);
        mVideoPlayer.setUp(mUrl,true,"");
        mVideoPlayer.startPlayLogic();
    }
}
