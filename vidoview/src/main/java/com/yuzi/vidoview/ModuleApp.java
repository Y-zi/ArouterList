package com.yuzi.vidoview;

//import com.alibaba.android.arouter.launcher.ARouter;

import com.yuzi.common.utils.app.BaseApplication;
import com.yuzi.common.utils.http.HttpUtils;

/**
 * Created by Y-zi on 2019/8/29
 * Github:https://github.com/Y-zi
 * QQ:992063180
 */
public class ModuleApp extends BaseApplication {

    private String isModule;


    @Override
    public void onCreate() {
        super.onCreate();
        isModule = getResources().getString(R.string.is_Moduel);
//        if (AppContent.IS_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
//        ARouter.init(this);//初始化路由
        if(isModule.equals("false")) {
//            Realm.init(this);//初始化数据库
            HttpUtils.init(this);//okgo初始化
        }
    }
}