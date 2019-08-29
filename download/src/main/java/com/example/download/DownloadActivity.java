package com.example.download;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.common.utils.Permission.PermissionSettingUtil;
import com.example.common.utils.app.BaseActivity;
import com.example.download.adapter.TaskListAdapter;
import com.example.download.utils.DownloadCallback;
import com.example.download.utils.DownloadRecord;
import com.example.download.utils.DownloadRequest;
import com.example.download.utils.DownloadUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Y-zi on 2019/8/29
 * Github:https://github.com/Y-zi
 * QQ:992063180
 */
public class DownloadActivity extends BaseActivity implements View.OnClickListener {
    EditText edtUrl;
    Button btnAdd;
    RecyclerView rvTasks;

//    String mDownloadUrl = "http://ftp-apk.pconline.com.cn/4da968ab4fd592239194501261cce88a/pub/download/201010/com.sdu.didi.psnger-v4.4.4_55032.apk";
    String mDownloadUrl = "http://dl.lockpays.com/cpl/apk/C10029/F106/10001/20190506191507/C10029F106_32bbf7077759a8a2_signed.apk";
    TaskListAdapter adapter;
    private  String[] PERMISSIONS_STORAGE = {//要动态申请的权限
            Manifest.permission.INTERNET,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int REQUEST_PERMISSION_CODE=54933;//动态读写权限申请码
    private List<String> mPermissionList = new ArrayList<>();//存储未授权的权限
    private AlertDialog mPermissionDialog;//未授权提示去开启

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

    @SuppressLint("ObsoleteSdkInt")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                mPermissionList.clear();//清空已经允许的没有通过的权限
                //逐个判断是否还有未通过的权限
                for (int i = 0; i < PERMISSIONS_STORAGE.length; i++) {
                    if (ContextCompat.checkSelfPermission(this, PERMISSIONS_STORAGE[i]) !=
                            PackageManager.PERMISSION_GRANTED) {
                        mPermissionList.add(PERMISSIONS_STORAGE[i]);//添加还未授予的权限到mPermissionList中
                    }
                }
                //申请权限
                if (mPermissionList.size() > 0) {//有权限没有通过，需要申请
                    ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
                } else {
                    //权限已经都通过了，可以将程序继续打开了
                    goDownload();
                }
                break;
        }
    }

    //权限回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //第一个参数为申请权限时候的标识（可自定义）
        //第二个是申请权限的数组
        //第三个是回应权限申请结果（0为已永久授权,即PackageManager.PERMISSION_GRANTED
        //                           -1为拒绝，即为 PackageManager.PERMISSION_DENIED ）
        boolean hasPermissionDismiss = false;//有权限没有通过
        if (REQUEST_PERMISSION_CODE == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    hasPermissionDismiss = true;
                    break;
                }
            }
        }
        if (hasPermissionDismiss) {//如果有没有被允许的权限
            showPermissionDialog();
        } else {
            //权限已经都通过了，可以将程序继续打开了
            goDownload();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private void goDownload(){//去下载
        if (!TextUtils.isEmpty(edtUrl.getText().toString())) {
            DownloadRequest request = DownloadRequest.newBuilder()
                    .downloadUrl(edtUrl.getText().toString())
                    .downloadName(System.currentTimeMillis() / 1000 + ".apk")
                    .build();
            DownloadUtil.get().enqueue(request);
        }
    }
    private void showPermissionDialog() {
        if (mPermissionDialog == null) {
            mPermissionDialog = new AlertDialog.Builder(this)
                    .setMessage("已禁用权限，请手动授予")
                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            cancelPermissionDialog();
                            PermissionSettingUtil.gotoSettingPermission(getApplicationContext());
//                            Uri packageURI = Uri.parse("package:" + "crazystudy.com.crazystudy");
//                            Intent intent = new Intent(Settings.
//                                    ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
//                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //关闭页面或者做其他操作
                            cancelPermissionDialog();

                        }
                    })
                    .create();
        }
        mPermissionDialog.show();
    }
    private void cancelPermissionDialog() {
        mPermissionDialog.cancel();
    }
}
