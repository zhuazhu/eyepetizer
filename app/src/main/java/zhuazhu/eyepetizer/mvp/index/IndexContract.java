package zhuazhu.eyepetizer.mvp.index;

import io.reactivex.Flowable;
import mejust.frame.mvp.BaseContract;
import zhuazhu.eyepetizer.mvp.index.model.IndexEntity;
import zhuazhu.eyepetizer.mvp.index.presenter.IndexAdapter;

/**
 * @author zhuazhu
 **/
public interface IndexContract {
    interface View extends BaseContract.View {
        /**
         * 设置adapter
         * @param adapter
         */
        void setAdapter(IndexAdapter adapter);

        void finishRefresh();
    }

    interface Presenter extends BaseContract.Presenter {
        /**
         * 获取首页数据
         * @param isFirstPage 是否是第一页数据
         */
        void queryIndexData(boolean isFirstPage);
    }

    interface Model {
        /**
         * 获取首页数据
         * @param isFirstPage 是否是第一页数据
         * @param date
         * @return
         */
        Flowable<IndexEntity> queryIndexData(boolean isFirstPage,String date);
    }
}