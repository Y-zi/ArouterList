package com.example.action;


import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.utils.app.BaseActivity;

public class StartActivity extends BaseActivity {
    //    ImageView iv;
    private boolean isFirstOpen = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            // 设置状态栏透明
            getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 判断是否是第一次开启应用

        // 如果是第一次启动，则先进入功能引导页
        if (!isFirstOpen) {
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        // 如果不是第一次启动app，则正常显示启动屏
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent;
//                intent = new Intent(StartActivity.this, MainActivity.class);
//                startActivity(intent);
                ARouter.getInstance()
//                bluetooth/进入蓝牙管理

                        .build("/show/跨组件页面")
                        .navigation(StartActivity.this, new NavCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("zhao", "onArrival: 找到了 ");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("zhao", "onArrival: 找不到了 ");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.e("zhao", "onArrival: 跳转完了 ");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("zhao", "onArrival: 被拦截了 ");
                            }
                        });


                finish();
            }
        }, 2000);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

//    public void onClick(View v) {
//        int i = v.getId();
//        if (i == R.id.iv) {//发起路由跳转
////            ARouter.getInstance()
////                    .build("/show/跨组件页面")
////                    .navigation(this, new NavCallback() {
////                        @Override
////                        public void onFound(Postcard postcard) {
////                            Log.e("zhao", "onArrival: 找到了 ");
////                        }
////
////                        @Override
////                        public void onLost(Postcard postcard) {
////                            Log.e("zhao", "onArrival: 找不到了 ");
////                        }
////
////                        @Override
////                        public void onArrival(Postcard postcard) {
////                            Log.e("zhao", "onArrival: 跳转完了 ");
////                        }
////
////                        @Override
////                        public void onInterrupt(Postcard postcard) {
////                            Log.e("zhao", "onArrival: 被拦截了 ");
////                        }
////                    });
//        }
//    }
}
