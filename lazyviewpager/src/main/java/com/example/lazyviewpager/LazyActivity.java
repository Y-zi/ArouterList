package com.example.lazyviewpager;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.Arrays;
@Route(path = "/laz/懒加载页面")
public class LazyActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.simple_expandable_list_item_1, Arrays.asList(new String[]{"LazyViewPagerAdapter", "LazyFragmentPagerAdapter"})));
        listView.setOnItemClickListener(this);
        setContentView(listView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (position == 0) {
            startActivity(new Intent(this, TestLazyViewPagerAdapterActivity.class));
        } else {
            startActivity(new Intent(this, TestLazyFragmentPagerAdapterActivity.class));
        }
    }

}
