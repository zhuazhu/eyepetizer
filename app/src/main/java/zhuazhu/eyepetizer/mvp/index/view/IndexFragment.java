package zhuazhu.eyepetizer.mvp.index.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import butterknife.BindView;
import mejust.frame.annotation.LayoutId;
import mejust.frame.mvp.view.BaseFragment;
import mejust.frame.mvp.view.BasePresenterFragment;
import zhuazhu.eyepetizer.R;
import zhuazhu.eyepetizer.app.EyeApp;
import zhuazhu.eyepetizer.di.module.IndexModule;
import zhuazhu.eyepetizer.mvp.index.IndexContract;
import zhuazhu.eyepetizer.mvp.index.presenter.IndexAdapter;

/**
 * @author zhuazhu
 **/
@LayoutId(R.layout.fragment_index)
public class IndexFragment extends BasePresenterFragment<IndexContract.Presenter> implements IndexContract.View,OnRefreshLoadmoreListener{
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    @Override
    protected void initData() {

    }

    @Override
    protected void injectComponent() {
        EyeApp.getAppComponent().indexComponent(new IndexModule(this)).inject(this);
    }

    @Override
    protected void initView() {
        mRefresh.setOnRefreshListener(this);
        mRefresh.setOnLoadmoreListener(this);
    }

    @Override
    public void setAdapter(IndexAdapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        presenter.queryIndexData(false);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        presenter.queryIndexData(true);
    }

    @Override
    public void finishRefresh() {
        mRefresh.finishRefresh(1000);
        mRefresh.finishLoadmore(1000);
    }
}
