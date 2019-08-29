package com.example.download.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Y-zi on 2019/8/29
 * Github:https://github.com/Y-zi
 * QQ:992063180
 */

public class TaskDispatcher extends Thread {
    private BlockingQueue<DownloadRecord> mRecordQueue;
    private volatile boolean mQuit = false;

    public TaskDispatcher() {
        mRecordQueue = new LinkedBlockingQueue<>();
    }

    public void quit() {
        mQuit = true;
        interrupt();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                DownloadRecord record = mRecordQueue.take();
                DownloadUtil.sDownloadPermit.acquire();
                if (record.getDownloadState() == DownloadUtil.STATE_REENQUEUE) {
                    DownloadUtil.get().resume(record.getId());
                } else {
                    DownloadUtil.get().start(record);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                if (mQuit) {
                    return;
                }
            }
        }
    }

    public void enqueueRecord(DownloadRecord record) {
        mRecordQueue.add(record);
    }
}
