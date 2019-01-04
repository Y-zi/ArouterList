package com.example.vidoview;

import android.media.MediaPlayer;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import android.widget.VideoView;

import com.dingmouren.layoutmanagergroup.viewpager.OnViewPagerListener;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;

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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VidoActivity extends BaseActivity {

    private String url="https://kuaiyinshi.com/api/kuai-shou/recommend";
    private RecyclerView mRecyclerView;
    private RvAdapter mAdapter;
    private ViewPagerLayoutManager mLayoutManager;
    private List<DataBean> dataBeanslist;
    private Gson gson;

    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_vido;
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.recycler);

        gson=new Gson();
        dataBeanslist=new ArrayList<>();
        mLayoutManager = new ViewPagerLayoutManager(act, OrientationHelper.VERTICAL);
        mAdapter = new RvAdapter(dataBeanslist, act);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        getdata();

    }

    @Override
    protected void initListener() {
        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                int index = 0;
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

    private void getdata() {

//        HashMap<String, String> params = new HashMap<>();
////        params.put("childFlag", "1");
////
////        params.put("userinvSort", String.valueOf(mPosition));
////
////        params.put("userinvSort", "1");
////        params.put("userinvSort", "2");

        HttpUtils.getdate(url,new StringCallback() {


            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject json = new JSONObject(String.valueOf(response.body()));
////                    total = jsonObject.optInt("total");
//                    List<DataBean> data = gson.fromJson(json.optJSONArray("data").toString(), new TypeToken<List<DataBean>>() {
//                    }.getType());
//                    if (data != null || data.size() != 0) {
//                        dataBeans.addAll(data);
//                        LogUtils.d("ssss","data不为空");
//                    }
                    List<DataBean> data = gson.fromJson(json.optJSONArray("data").toString(), new TypeToken<List<DataBean>>() {
                    }.getType());
                    for (int i = 0; i < data.size(); i++) {
                        dataBeanslist.add(data.get(i));
                    }
                    data.clear();
                    data = null;

                } catch (Exception e) {
                    Log.d(act.toString(), "解析异常");
                } finally {

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
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
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
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        videoView.stopPlayback();
        imgThumb.animate().alpha(1).start();
        imgPlay.animate().alpha(0f).start();
    }
}
