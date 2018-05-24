package zhuazhu.eyepetizer.mvp.index.presenter;

import android.support.annotation.NonNull;
import android.widget.Adapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.ResourceSubscriber;
import mejust.frame.mvp.presenter.BasePresenter;
import mejust.frame.widget.adapter.RecyclerAdapter;
import zhuazhu.eyepetizer.mvp.detail.view.DetailActivity;
import zhuazhu.eyepetizer.mvp.index.IndexContract;
import zhuazhu.eyepetizer.mvp.index.model.IndexEntity;
import zhuazhu.eyepetizer.mvp.index.model.IndexModel;
import zhuazhu.eyepetizer.mvp.index.model.IndexResult;

/**
 * @author zhuazhu
 **/
public class IndexPresenter extends BasePresenter<IndexContract.View> implements IndexContract.Presenter {
    private final IndexContract.Model mModel;
    private final IndexAdapter mIndexAdapter;
    public IndexPresenter(@NonNull IndexContract.View view, IndexModel indexModel,IndexAdapter indexAdapter) {
        super(view);
        mIndexAdapter = indexAdapter;
        mModel = indexModel;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mView.setAdapter(mIndexAdapter);
        queryIndexData(true);
        mIndexAdapter.setOnItemClickListener((RecyclerAdapter.OnItemClickListener<IndexResult>) (id, result, position) -> {
            DetailActivity.start(getViewActivity(),result.getPlayUrl());
        });
    }

    private String mDate;
    @Override
    public void queryIndexData(boolean isFirstPage) {
        disposable.add(mModel.queryIndexData(isFirstPage,mDate).subscribeWith(new ResourceSubscriber<IndexEntity>() {
            @Override
            public void onNext(IndexEntity indexEntity) {
                String url = indexEntity.getNextPageUrl();
                int fromIndex = url.indexOf("=")+1;
                int toIndex = url.indexOf("&");
                mDate = url.substring(fromIndex,toIndex);
                List<IndexResult> list = new ArrayList<>();
                List<IndexEntity.Issue> issues = indexEntity.getIssueList();
                for (IndexEntity.Issue issue : issues) {
                    List<IndexEntity.Item> items = issue.getItemList();
                    for (IndexEntity.Item item : items) {
                        String type = item.getType();
                        if ("video".equals(type)) {
                            IndexResult result = new IndexResult();
                            IndexEntity.Data data = item.getData();
                            IndexEntity.Author author = data.getAuthor();
                            IndexEntity.Cover cover = data.getCover();
                            result.setTitle(data.getTitle());
                            result.setDescription(data.getDescription());
                            result.setCategory(data.getCategory());
                            result.setAuthor(author.getName());
                            result.setAuthorIcon(author.getIcon());
                            result.setDuration(data.getDuration());
                            result.setImageUrl(cover.getFeed());
                            result.setPlayUrl(data.getPlayUrl());
                            list.add(result);
                        }
                    }
                }
                if(isFirstPage){
                    mIndexAdapter.set(list);
                }else{
                    mIndexAdapter.add(list);
                }
                mView.finishRefresh();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        }));
    }
}
