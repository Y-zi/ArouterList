package com.example.action;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.action.viewpager.GuideCustomRL;
import com.example.common.utils.app.BaseActivity;

import java.net.URL;

import static com.example.action.R.id.autoviewpager;

public class GuideActivity extends BaseActivity implements View.OnClickListener {

    GuideCustomRL gg ;
    Button btn_start;
    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏通知栏（一定要在set布局前面设置）
        return R.layout.activity_guide;
    }
    @Override
    protected void initView() {
//        设置窗体全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



//        View view = LayoutInflater.from(this).inflate(R.activity_download.guide_view_four, null);
//        LayoutInflater inflater = this.getLayoutInflater();                             //先获取当前布局的填充器
//        View view = inflater.inflate(R.activity_download.guide_view_four, null);   //通过填充器获取另外一个布局的对象
//        btn_start = view.findViewById(R.id.btn_start);     //通过另外一个布局对象的findViewById获取其中的控件

        btn_start =findViewById(R.id.btn_start);
        gg=findViewById(R.id.autoviewpager);
        gg.setOnClickListener(this);
//        btn_start.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    public void onClick(View v) {

        Log.e("dianji","");
        //发起路由跳转
//        ARouter.getInstance()
//                .build("/show/跨组件页面")
//                .navigation(this, new NavCallback() {
//                    @Override
//                    public void onFound(Postcard postcard) {
//                        Log.e("zhao", "onArrival: 找到了 ");
//                    }
//
//                    @Override
//                    public void onLost(Postcard postcard) {
//                        Log.e("zhao", "onArrival: 找不到了 ");
//                    }
//
//                    @Override
//                    public void onArrival(Postcard postcard) {
//                        Log.e("zhao", "onArrival: 跳转完了 ");
//                    }
//
//                    @Override
//                    public void onInterrupt(Postcard postcard) {
//                        Log.e("zhao", "onArrival: 被拦截了 ");
//                    }
//                });
    }

}
