package com.example.download;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.common.utils.app.BaseActivity;
import com.example.download.adapter.TaskListAdapter;
import com.example.download.utils.DownloadCallback;
import com.example.download.utils.DownloadRecord;
import com.example.download.utils.DownloadRequest;
import com.example.download.utils.DownloadUtil;

public class DownloadActivity extends BaseActivity implements View.OnClickListener {
    EditText edtUrl;
    Button btnAdd;
    RecyclerView rvTasks;

    String mDownloadUrl = "http://ftp-apk.pconline.com.cn/4da968ab4fd592239194501261cce88a/pub/download/201010/com.sdu.didi.psnger-v4.4.4_55032.apk";
    TaskListAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_download;
    }

    @Override
    protected void initView() {
        edtUrl=findViewById(R.id.edtUrl);
        btnAdd=findViewById(R.id.btnAdd);
        rvTasks=findViewById(R.id.rvTasks);

    }

    @Override
    protected void initData() {
        DownloadUtil.get().init(this);
        edtUrl.setText(mDownloadUrl);
        adapter = new TaskListAdapter(this);
        adapter.setData(DownloadUtil.get().getAllTasks());
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        rvTasks.setAdapter(adapter);
        DownloadUtil.get().registerListener(this, new DownloadCallback() {
            @Override
            public void onProgress(DownloadRecord record) {
                int index = findRecordIndex(record);
                adapter.notifyItemChanged(index, "payload");
            }

            @Override
            public void onNewTaskAdd(DownloadRecord record) {
                adapter.setData(DownloadUtil.get().getAllTasks());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailed(DownloadRecord record, String errMsg) {
                Toast.makeText(act, errMsg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStart(DownloadRecord record) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFinish(DownloadRecord record) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPaused(DownloadRecord record) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onReEnqueue(DownloadRecord record) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onResume(DownloadRecord record) {
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void initListener() {
        btnAdd.setOnClickListener(this);

    }
    private int findRecordIndex(DownloadRecord record) {
        for(int i = 0; i<adapter.getItemCount(); i++){
            if(record == adapter.getItem(i))
                return i;
        }
        return -1;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DownloadUtil.get().destroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                if (!TextUtils.isEmpty(edtUrl.getText().toString())) {
                    DownloadRequest request = DownloadRequest.newBuilder()
                            .downloadUrl(edtUrl.getText().toString())
                            .downloadName(System.currentTimeMillis() / 1000 + ".apk")
                            .build();
                    DownloadUtil.get().enqueue(request);
                }
                break;
        }
    }
}
