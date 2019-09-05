/*
*
* package com.yuzi.common.utils;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MyThread implements Runnable {
    @Override
    public void run() {
        //下载一个图片
        HttpClient httpclient = new DefaultHttpclient();
        HttpGet httpGet = new HttpGet(imagepath);
        HttpResponse httpresponse = null;
        try {
            httpresponse = httpclient.execute(httpGet);
            if (httpresponse.getStatusline().getstatuscode() == 200) {
                byte[] data = EntityUtils.toByteArray(httpresponse.getEntity());
            }
            //必须final 使Bitm对象可以在Runnable中使用
            final Bitmap bitmap = new BitmapFactory().decoteByteArray(data,0,data.length());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    ivimage.setimagebitmap(bitmap);
                }
            });//隐藏对话框
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
*/