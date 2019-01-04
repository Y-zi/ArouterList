package com.example.common.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

public class DPUtils {

    /**
     * dp转为px（px都是整数）
     */
    public static int dp2px(Activity act, float dp) {
        // 32dp - px dpi/160
        // 1、获取或计算dpi (dm)
        DisplayMetrics dm = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        // 2、dpi/160 倍数（dp和px）
        // 3、px = dp*倍数
        return (int) (dp * dm.densityDpi / 160 + 0.5F); // 四舍五入
    }

    /**
     * px转为dp
     */
    public static float px2dp(Activity act, float px) {
        // 32dp - px dpi/160
        // 1、获取或计算dpi (dm)
        DisplayMetrics dm = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        // 2、dpi/160 倍数（dp和px）
        // 3、px = dp*倍数（dp=px/倍数）
        return px / dm.densityDpi * 160;
    }

}
