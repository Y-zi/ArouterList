package com.yuzi.download.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Y-zi on 2019/8/29
 * Github:https://github.com/Y-zi
 * QQ:992063180
 */
class DataHelper {
    private SharedPreferences sp;
    private Gson gson;

    DataHelper(Context context) {
        sp = context.getSharedPreferences("download_task", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    void saveAllRecord(Collection<DownloadRecord> records){
        for (DownloadRecord record : records) {
            saveRecord(record);
        }
    }

    void saveRecord(DownloadRecord record){
        String json = gson.toJson(record);
        sp.edit().putString(record.getId(), json).commit();
        Log.e("DataHelper", json);
    }

    List<DownloadRecord> loadAllRecords(){//记录所有任务
        Map<String, String> map = (Map<String, String>) sp.getAll();
        List<DownloadRecord> list = new ArrayList<>();
        for (String json: map.values()) {
            Log.e("DataHelper", json);
            DownloadRecord record = gson.fromJson(json, DownloadRecord.class);
            record.linkSubTask();
            list.add(record);
        }
        Collections.sort(list);
        return list;
    }

}
