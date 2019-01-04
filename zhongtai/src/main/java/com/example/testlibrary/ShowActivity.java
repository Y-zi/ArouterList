package com.example.testlibrary;

import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.utils.app.BaseActivity;

import static com.example.testlibrary.R.id.bottom1;

@Route(path ="/show/跨组件页面")
public class ShowActivity extends BaseActivity implements View.OnClickListener {
    private Button button1,button2,button3,button4;
    @Override
    protected int getLayoutId() {
        return R.layout.show_activity;
    }

    @Override
    protected void initView() {
        button1=findViewById(bottom1);
        button2=findViewById(R.id.button2);

    }
    @Override
    protected void initData() {

    }
    @Override
    protected void initListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.print("ss支付方");
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bottom1){
            ARouter.getInstance().build("/bluetooth/进入蓝牙管理").navigation();
        }else{
            ARouter.getInstance().build("/laz/懒加载页面").navigation();
        }
    }
}
