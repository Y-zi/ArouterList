package com.example.vidoview;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VidoActivity extends BaseActivity {
    //https://kuaiyinshi.com/api/dou-yin/recommend/
    //https://kuaiyinshi.com/api/kuai-shou/recommend/
    //https://kuaiyinshi.com/api/mei-pai/recommend/
    private String url = "https://kuaiyinshi.com/api/kuai-shou/recommend/";
    private RecyclerView mRecyclerView;
    private RvAdapter mAdapter;
    private ViewPagerLayoutManager mLayoutManager;
    private List<DataBean> dataBeanslist;
    private DataBean.Statistics statistics;
//    private SmartRefreshLayout smartpefresh;
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
//        smartpefresh = findViewById(R.id.smartpefresh);
//        smartpefresh.setEnableLoadMore(true);//开启上拉加载

//        AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(act)
//                .setMessage("选择")
//                .setNeutralButton("美拍", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                }).setPositiveButton("快手", new DialogInterface.OnClickListener() {//添加"Yes"按钮
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        url="https://kuaiyinshi.com/api/kuai-shou/recommend/";
//                    }
//                });
//        alertDialog1.show();
        mRecyclerView = findViewById(R.id.recycler);
//        auto=findViewById(R.id.auto);
        dataBeanslist = new ArrayList<>();
//        dataBeanslist.get
        mLayoutManager = new ViewPagerLayoutManager(act, OrientationHelper.VERTICAL);
//        AsyncTask;
        mAdapter = new RvAdapter(dataBeanslist, act);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {
//        smartpefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                getData();
//            }
//        });
        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
//                if (!isNext) getData();
                int index;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                releaseVideo(index);
                if (position == dataBeanslist.size() - 2) getData();

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
//                Log.e("huidiao", response.body());
                try {
                    JSONObject json = new JSONObject(response.body());
//                    Result<JsonRootBean> result = JsonUtils.toBean(json.optJSONArray("data"),JsonUtils.newParamType(Result.class,JsonRootBean.class));
//                    Log.e("huidiao", "result.toString.lenth"+result.toString().length());
                    List<DataBean> simlist = new Gson().fromJson(json.optJSONArray("data").toString().replace(":null", ":\"\""), new TypeToken<List<DataBean>>() {
                    }.getType());
                    dataBeanslist.addAll(simlist);
//                    DataBean.Statistics vList = new Gson().fromJson(json.optJSONArray("statistics").toString(), DataBean.Statistics.class);

                    mAdapter.notifyDataSetChanged();
                    Log.e("huidiao1", String.valueOf(dataBeanslist.size()));
                } catch (Exception e) {
                    Log.e("huidiao800", e.toString());
                }
            }

            @Override
            public void onError(Response<String> response) {
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(act)
                        .setMessage("请检查网络")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                alertDialog2.show();
//                Log.e("error_net", response.message().toString());
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

//    private void refreshData() {
//        page = 1;
//        invoiceMainModelList.clear();
//        getInvoicList();
//    }

}
