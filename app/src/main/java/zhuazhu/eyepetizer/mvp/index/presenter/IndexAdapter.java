package zhuazhu.eyepetizer.mvp.index.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mejust.frame.annotation.Adapter;
import mejust.frame.image.ImageUtils;
import mejust.frame.widget.adapter.BaseViewHolder;
import mejust.frame.widget.adapter.RecyclerAdapter;
import zhuazhu.eyepetizer.R;
import zhuazhu.eyepetizer.mvp.index.model.IndexResult;

/**
 * @author zhuazhu
 **/
@Adapter(layout = R.layout.item_index, holder = IndexAdapter.ViewHolder.class)
public class IndexAdapter extends RecyclerAdapter<IndexResult, IndexAdapter.ViewHolder> {

    @Override
    public void bindViewHolder(ViewHolder holder, IndexResult indexResult, int position) {
        ImageUtils.showRound(holder.mImg, indexResult.getImageUrl(), 5);
        /**
         * 处理时长的分钟和秒数总是显示两位
         */
        int duration = indexResult.getDuration();
        StringBuffer buffer = new StringBuffer();
        int d1 = duration / 60;
        if (d1 < 10) {
            buffer.append("0");
        }
        buffer.append(d1);
        buffer.append(":");
        int d2 = duration % 60;
        if (d2 < 10) {
            buffer.append("0");
        }
        buffer.append(d2);
        holder.mTime.setText(buffer.toString());

        ImageUtils.showCircle(holder.mIcon, indexResult.getAuthorIcon());

        holder.mTitle.setText(indexResult.getTitle());
        String detail = String.format("%s / #%s",indexResult.getAuthor(),indexResult.getCategory());
        holder.mDetail.setText(detail);
    }


    public static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.img)
        ImageView mImg;
        @BindView(R.id.time)
        TextView mTime;
        @BindView(R.id.icon)
        ImageView mIcon;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.detail)
        TextView mDetail;

        ViewHolder(View view) {
            super(view, false);
            ButterKnife.bind(this, view);
        }
    }
}
