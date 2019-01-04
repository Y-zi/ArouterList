package com.example.common.utils.app;

import android.app.Application;
import java.nio.charset.Charset;


/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * @name BaseApplication
 */
public class BaseApplication extends Application {
    public static final String TAG = "appInterceptor";
    public static final String ROOT_PACKAGE = "";

    private static BaseApplication sInstance;
    private String saas_proappcode = "";
    private String saas_tenantcode = "";

    public String getSaas_proappEnv() {
        return saas_proappEnv;
    }

    public void setSaas_proappEnv(String saas_proappEnv) {
        this.saas_proappEnv = saas_proappEnv;
    }

    public String getSaas_tginfocode() {
        return saas_tginfocode;
    }

    public void setSaas_tginfocode(String saas_tginfocode) {
        this.saas_tginfocode = saas_tginfocode;
    }
    private String saas_proappEnv = "";
    private String saas_tginfocode = "";

    public String getCookie_name() {
        return cookie_name;
    }

    public void setCookie_name(String cookie_name) {
        this.cookie_name = cookie_name;
    }

    public String getCookie_value() {
        return cookie_value;
    }

    public void setCookie_value(String cookie_value) {
        this.cookie_value = cookie_value;
    }

    private String cookie_name = "";
    private String cookie_value = "";
    private String token = "";

    public static BaseApplication getInstance() {
        if (null == sInstance) {
            sInstance = new BaseApplication();
        }
        return sInstance;
    }




    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSaas_proappcode() {
        return saas_proappcode;
    }

    public void setSaas_proappcode(String saas_proappcode) {
        this.saas_proappcode = saas_proappcode;
    }

    public String getSaas_tenantcode() {
        return saas_tenantcode;
    }

    public void setSaas_tenantcode(String saas_tenantcode) {
        this.saas_tenantcode = saas_tenantcode;
    }

    private static final Charset UTF8 = Charset.forName("UTF-8");

}
