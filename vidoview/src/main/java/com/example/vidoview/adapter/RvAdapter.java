package com.example.vidoview.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.common.utils.http.HttpUtils;
import com.example.vidoview.R;
import com.example.vidoview.bean.DataBean;
import com.example.vidoview.bean.JsonRootBean;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{
//        private int[] imgs = {R.mipmap.video11,R.mipmap.video12,R.mipmap.video13,R.mipmap.video14,R.mipmap.img_video_2};
//        private int[] videos = {R.raw.video11,R.raw.video12,R.raw.video13,R.raw.video14,R.raw.video_2};
        private List<DataBean> dataBeanslist;
        private Context context;
    public RvAdapter(List<DataBean> dataBeanslist ,Context context) {
        this.dataBeanslist = dataBeanslist;
        this.context = context;
    }
    @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager,parent,false);
            return new ViewHolder(view);
        }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.e("huidiao2", String.valueOf(dataBeanslist.size()));
//        holder.img_thumb.setImageResource(imgs[position % 5]);
//        holder.videoView.setVideoURI(Uri.parse("android.resource://" + "com.example.administrator.douyinviewpager" + "/" + videos[position % 5]));
        final DataBean dataBean = dataBeanslist.get(i);
        final DataBean.Statistics statistics=dataBean.getStatistics();
        viewHolder.nickname.setText(dataBean.getNickname());
        Log.d("二级", String.valueOf(statistics.getZan()));
//        String video_action= "http://aweme.snssdk.com/aweme/v1/play/?video_id=";
        Glide.with(context).load("https:"+dataBean.getVideo_img()).into(viewHolder.video_img);
        Glide.with(context).load("https:"+dataBean.getAvatar()).into(viewHolder.avatar);
        //http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
        //http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4
        //可用
        //vidourl密文 89 533字符
//        viewHolder.videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));

//        viewHolder.zan.setText(statistics.getZan());
//        viewHolder.zan.setText(dataBean.getStatistics().getComment());
//        viewHolder.zan.setText(dataBean.getStatistics().getPlay()+"次播放");
//        viewHolder.zan.setText(dataBean.getStatistics().getShare());

        }
        @Override
        public int getItemCount() {
            return dataBeanslist.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//            ImageView img_thumb;
            VideoView videoView;//播放器
            ImageView img_play;//播放按钮
            ImageView avatar;//头像
            TextView nickname;//昵称
            ImageView video_img;//视频初始图片
            TextView zan;
            TextView share;
            TextView comment;
            public ViewHolder(View itemView) {
                super(itemView);
//                img_thumb = itemView.findViewById(R.id.img_thumb);
                videoView = itemView.findViewById(R.id.video_view);
                video_img=itemView.findViewById(R.id.video_img);
                img_play = itemView.findViewById(R.id.img_play);
                avatar=itemView.findViewById(R.id.avatar);
                nickname=itemView.findViewById(R.id.nickname);
                zan=itemView.findViewById(R.id.shoucang);
                share=itemView.findViewById(R.id.pinglun);
                comment=itemView.findViewById(R.id.zhuanfa);

                img_play.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {


            }
        }

}
