package com.yuzi.download.utils;

/**
 * Created by Y-zi on 2019/8/29
 * Github:https://github.com/Y-zi
 * QQ:992063180
 */

interface DownloadListener{


    void onProgress(DownloadRecord record);

    void onNewTaskAdd(DownloadRecord record);

    void onFailed(DownloadRecord record, String errMsg);//错误消息

    void onPaused(DownloadRecord record);

    void onStart(DownloadRecord record);

    void onResume(DownloadRecord record);

    void onReEnqueue(DownloadRecord record);

    void onFinish(DownloadRecord record);

    void onFileLengthGet(DownloadRecord record);

    void onCanceled(DownloadRecord record);
}