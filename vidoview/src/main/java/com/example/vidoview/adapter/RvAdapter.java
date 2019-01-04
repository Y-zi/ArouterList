package com.example.vidoview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.vidoview.R;
import com.example.vidoview.bean.DataBean;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{
//        private int[] imgs = {R.mipmap.video11,R.mipmap.video12,R.mipmap.video13,R.mipmap.video14,R.mipmap.img_video_2};
//        private int[] videos = {R.raw.video11,R.raw.video12,R.raw.video13,R.raw.video14,R.raw.video_2};
        private List<DataBean> dataBeans;
        private Context context;

    public RvAdapter(List<DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
    }

    @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager,parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.img_thumb.setImageResource(imgs[position%5]);
//            holder.videoView.setVideoURI(Uri.parse("android.resource://"+"com.example.administrator.douyinviewpager"+"/"+ videos[position%5]));
//            DataBean dataBean = dataBeans.get(position);
//            holder.nickname.setText(dataBean.getNickname());
//            holder.zan.setText(dataBean);

    }
        @Override
        public int getItemCount() {
            return 50;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
//            ImageView img_thumb;
            VideoView videoView;//播放器
            ImageView img_play;//播放按钮
            ImageView iv_cir;//头像
            TextView nickname;//昵称
            TextView zan;
            TextView share;
            TextView comment;

            public ViewHolder(View itemView) {
                super(itemView);
//                img_thumb = itemView.findViewById(R.id.img_thumb);
                videoView = itemView.findViewById(R.id.video_view);
                img_play = itemView.findViewById(R.id.img_play);
                iv_cir=itemView.findViewById(R.id.iv_cir);
                nickname=itemView.findViewById(R.id.nickname);
                zan=itemView.findViewById(R.id.shoucang);
                share=itemView.findViewById(R.id.pinglun);
                comment=itemView.findViewById(R.id.zhuanfa);

            }
        }
}
