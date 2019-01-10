package com.example.vidoview;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import android.widget.Toast;
import android.widget.VideoView;

import com.dingmouren.layoutmanagergroup.viewpager.OnViewPagerListener;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;

import com.example.common.utils.JsonUtils;
import com.example.common.utils.LogUtils;
import com.example.common.utils.app.BaseActivity;
import com.example.common.utils.http.HttpUtils;
import com.example.common.utils.http.JsonCallback;
import com.example.vidoview.adapter.RvAdapter;
import com.example.vidoview.bean.DataBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.model.Result;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VidoActivity extends BaseActivity {
    //https://kuaiyinshi.com/api/dou-yin/recommend/
    //https://kuaiyinshi.com/api/kuai-shou/recommend/
    //https://kuaiyinshi.com/api/mei-pai/recommend/
    private String url = "https://kuaiyinshi.com/api/mei-pai/recommend/";
    private RecyclerView mRecyclerView;
    private RvAdapter mAdapter;
    private ViewPagerLayoutManager mLayoutManager;
    private List<DataBean> dataBeanslist;
    private DataBean.Statistics statistics;

    //    AutoCompleteTextView auto;
    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getData();
        return R.layout.activity_vido;
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.recycler);
//        auto=findViewById(R.id.auto);
        dataBeanslist = new ArrayList<>();
//        dataBeanslist.get
        mLayoutManager = new ViewPagerLayoutManager(act, OrientationHelper.VERTICAL);
//        AsyncTask;

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                int index;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                releaseVideo(index);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {

                playVideo(0);
            }

            public void onLayoutComplete() {
                playVideo(0);
            }
        });

    }

    private void getData() {
        HttpUtils.getdate(url, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Log.e("huidiao", response.body());
                try {
                    JSONObject json = new JSONObject(response.body());
//                    Result<JsonRootBean> result = JsonUtils.toBean(json.optJSONArray("data"),JsonUtils.newParamType(Result.class,JsonRootBean.class));
//                    Log.e("huidiao", "result.toString.lenth"+result.toString().length());
                    List<DataBean> simlist = new Gson().fromJson(json.optJSONArray("data").toString().replace(":null", ":\"\""), new TypeToken<List<DataBean>>() {
                    }.getType());
                    dataBeanslist.addAll(simlist);
//                    DataBean.Statistics vList = new Gson().fromJson(json.optJSONArray("statistics").toString(), DataBean.Statistics.class);
//                    Log.d("rst:" , String.valueOf(vList.getZan()));
//                    Log.d("msg:" , String.valueOf(vList.getComment()));
//                    Log.d("data:" , String.valueOf(vList.getPlay()));


                    mAdapter = new RvAdapter(dataBeanslist, act);
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    Log.e("huidiao1", String.valueOf(dataBeanslist.size()));
                } catch (Exception e) {
                    Log.e("huidiao800", e.toString());
                }


            }

            @Override
            public void onError(Response<String> response) {
                Log.e("error_net", response.message().toString());
            }
        });
    }

    private void playVideo(int position) {
        View itemView = mRecyclerView.getChildAt(0);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        final ImageView imgThumb = itemView.findViewById(R.id.video_img);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.start();
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mediaPlayer[0] = mp;
                mp.setLooping(true);
                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });


        imgPlay.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = true;

            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    imgPlay.animate().alpha(1f).start();
                    videoView.pause();
                    isPlaying = false;
                } else {

                    imgPlay.animate().alpha(0f).start();
                    videoView.start();
                    isPlaying = true;
                }
            }
        });
    }

    private void releaseVideo(int index) {
        View itemView = mRecyclerView.getChildAt(index);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.video_img);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        videoView.stopPlayback();
        imgThumb.animate().alpha(1).start();
        imgPlay.animate().alpha(0f).start();
    }
}
