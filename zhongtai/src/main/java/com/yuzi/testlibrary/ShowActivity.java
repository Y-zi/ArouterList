package com.yuzi.testlibrary;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yuzi.common.utils.app.BaseActivity;
import com.yuzi.testlibrary.R;

@Route(path ="/show/跨组件页面")
public class ShowActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private Button btinbluetooth,btinlazyviewpager,btinvidoview,btinjiexi;
    private RadioGroup rgselectRb;
    private int selectis=-1;
    @Override
    protected int getLayoutId() {
        return R.layout.show_activity;
    }

    @Override
    protected void initView() {
        btinbluetooth=findViewById(R.id.com_bt_inbluetooth);
        btinlazyviewpager=findViewById(R.id.com_bt_inlazyviewpager);
        btinvidoview=findViewById(R.id.com_bt_invidoview);
        btinjiexi=findViewById(R.id.com_bt_injiexi);

        rgselectRb=findViewById(R.id.com_rg_selectRb);
    }
    @Override
    protected void initData() {

    }
    @Override
    protected void initListener() {
        btinbluetooth.setOnClickListener(this);
        btinlazyviewpager.setOnClickListener(this);
        btinvidoview.setOnClickListener(this);
        btinjiexi.setOnClickListener(this);

        rgselectRb.setOnCheckedChangeListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.com_bt_inbluetooth) {
            ARouter.getInstance().build("/bluetooth/进入蓝牙管理").navigation();
        } else if (id == R.id.com_bt_inlazyviewpager) {
            ARouter.getInstance().build("/laz/懒加载页面").navigation();
        } else if (id == R.id.com_bt_invidoview) {
            if (selectis != -1) {
                ARouter.getInstance().build("/vidoview/短视频")
                        .withInt("selectid", selectis)
                        .navigation();
            }
        } else if (id == R.id.com_bt_injiexi) {
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.com_rg_rb_mp) {
            selectis=0;
        }else if (i==R.id.com_rg_rb_ks){
            selectis=1;
        }
    }
}
