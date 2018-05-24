package zhuazhu.eyepetizer.mvp.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import butterknife.OnClick;
import mejust.frame.annotation.LayoutId;
import mejust.frame.annotation.TitleBarConfig;
import mejust.frame.mvp.view.BaseActivity;
import zhuazhu.eyepetizer.R;
import zhuazhu.eyepetizer.mvp.find.FindFagment;
import zhuazhu.eyepetizer.mvp.hot.HotFragment;
import zhuazhu.eyepetizer.mvp.index.view.IndexFragment;
import zhuazhu.eyepetizer.mvp.mine.MineFragment;

@LayoutId(R.layout.activity_main)
@TitleBarConfig(textValue = "", visible = false)
public class MainActivity extends BaseActivity {


    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    private FragmentManager mFragmentManager;
    private IndexFragment mIndexFragment;
    private FindFagment mFindFagment;
    private HotFragment mHotFragment;
    private MineFragment mMineFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStatusBar.statusBarView(R.id.top_view).statusBarDarkFont(true).init();
        initView();
    }
    private void initView(){
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (mIndexFragment==null) {
            mIndexFragment = new IndexFragment();
            transaction.add(R.id.fragment,mIndexFragment);
        }
        if (mFindFagment==null) {
            mFindFagment = new FindFagment();
            transaction.add(R.id.fragment,mFindFagment);
        }
        if (mHotFragment==null) {
            mHotFragment = new HotFragment();
            transaction.add(R.id.fragment,mHotFragment);
        }
        if (mMineFragment==null) {
            mMineFragment = new MineFragment();
            transaction.add(R.id.fragment,mMineFragment);
        }
        transaction.commit();
        clickIndex();
    }

    /**
     * 点击首页
     */
    @OnClick(R.id.radio_index)
    protected void  clickIndex(){
        mFragmentManager.beginTransaction().show(mIndexFragment).hide(mFindFagment).hide(mHotFragment).hide(mMineFragment).commit();
    }

    /**
     * 点击发现
     */
    @OnClick(R.id.radio_find)
    protected void clickFind(){
        mFragmentManager.beginTransaction().show(mFindFagment).hide(mIndexFragment).hide(mHotFragment).hide(mMineFragment).commit();
    }

    /**
     * 点击热门
     */
    @OnClick(R.id.radio_hot)
    protected void clickHot(){
        mFragmentManager.beginTransaction().show(mHotFragment).hide(mFindFagment).hide(mIndexFragment).hide(mMineFragment).commit();
    }

    /**
     * 点击我的
     */
    @OnClick(R.id.radio_mine)
    protected void clickMine(){
        mFragmentManager.beginTransaction().show(mMineFragment).hide(mFindFagment).hide(mHotFragment).hide(mIndexFragment).commit();
    }
}
