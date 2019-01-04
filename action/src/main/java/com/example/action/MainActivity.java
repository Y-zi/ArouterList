//package com.example.action;
//
//
//import android.util.Log;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.ImageView;
//
//import com.alibaba.android.arouter.facade.Postcard;
//import com.alibaba.android.arouter.facade.callback.NavCallback;
//import com.alibaba.android.arouter.launcher.ARouter;
//import com.example.common.utils.app.BaseActivity;
//
//public class MainActivity extends BaseActivity {
////    ImageView iv;
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    protected void initView() {
////        requestWindowFeature(Window.FEATURE_NO_TITLE);
////        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    protected void initListener() {
//
//    }
//
////    public void onClick(View v) {
////        int i = v.getId();
////        if (i == R.id.iv) {//发起路由跳转
//////            ARouter.getInstance()
//////                    .build("/show/跨组件页面")
//////                    .navigation(this, new NavCallback() {
//////                        @Override
//////                        public void onFound(Postcard postcard) {
//////                            Log.e("zhao", "onArrival: 找到了 ");
//////                        }
//////
//////                        @Override
//////                        public void onLost(Postcard postcard) {
//////                            Log.e("zhao", "onArrival: 找不到了 ");
//////                        }
//////
//////                        @Override
//////                        public void onArrival(Postcard postcard) {
//////                            Log.e("zhao", "onArrival: 跳转完了 ");
//////                        }
//////
//////                        @Override
//////                        public void onInterrupt(Postcard postcard) {
//////                            Log.e("zhao", "onArrival: 被拦截了 ");
//////                        }
//////                    });
////        }
////    }
//}
