package com.yuzi.vidoview.bean;

import java.util.List;

/**
 * Copyright 2019 bejson.com
 * Auto-generated: 2019-01-07 14:40:1
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private int code;
    private List<DataBean> datas;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setData(List<DataBean> datas) {
        this.datas = datas;
    }
    public List<DataBean> getData() {
        return datas;
    }

}