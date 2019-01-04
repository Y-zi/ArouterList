package com.example.lenovo;

//import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.utils.LogUtils;
import com.example.common.utils.app.AppContent;
import com.example.common.utils.app.BaseApplication;
import com.example.common.utils.app.Utils;
import com.example.common.utils.http.HttpUtils;

import io.realm.Realm;

/**
 * Created by Administrator on 2018\12\15 
 */
public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (AppContent.IS_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);//初始化路由
        Realm.init(this);//初始化数据库
        HttpUtils.init(this);//okgo初始化
    }
}