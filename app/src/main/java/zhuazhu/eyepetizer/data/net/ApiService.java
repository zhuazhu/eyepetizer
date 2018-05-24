package zhuazhu.eyepetizer.data.net;

import io.reactivex.Flowable;
import mejust.frame.annotation.ServiceUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhuazhu.eyepetizer.mvp.index.model.IndexEntity;

/**
 * @author zhuazhu
 **/
@ServiceUrl("http://baobab.kaiyanapp.com/api/")
public interface ApiService {
    /**
     * 获取首页的第一页数据
     * @param num
     * @param uuid
     * @param vc
     * @return
     */
    @GET("v2/feed")
    Flowable<IndexEntity> queryFirstForIndex(@Query("num")int num,@Query("udid")String uuid,@Query("vc")int vc);

    /**
     * 获取首页更多的数据
     * @param num
     * @param date
     * @return
     */
    @GET("v2/feed")
    Flowable<IndexEntity> queryMoreForIndex(@Query("num")int num,@Query("date")String date);
}
