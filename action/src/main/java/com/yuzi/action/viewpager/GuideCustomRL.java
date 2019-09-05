package com.yuzi.action.viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.yuzi.action.R;

import java.util.ArrayList;
import java.util.List;


public class GuideCustomRL extends RelativeLayout {

    private PagerAdapter mAdapter = new PagerAdapter() {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mViewList.get(position);
            container.addView(view);
            return view;//此方法扩展性低无法拿到单个子项内点击事件
        }
        @Override
        public int getCount() {
            return mViewList == null ? 0 : mViewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    };
    private ViewPager mViewPager;
    private TransforCustomView mTransforView;
    private List<View> mViewList = new ArrayList<>();
    private int[] mLayouts = new int[]{R.layout.guide_view_one, R.layout.guide_view_two, R.layout.guide_view_three,
            R.layout.guide_view_four};

    public GuideCustomRL(Context context) {
        super(context);
        init();
    }

    public GuideCustomRL(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.layout_viewpager, this);

        mViewPager = findViewById(R.id.viewpager);
        mTransforView = findViewById(R.id.transfor_view);


        /** 初始化4个页面 */
        for (int i = 0; i < mLayouts.length; i++) {
            View view = View.inflate(getContext(), mLayouts[i], null);
            mViewList.add(view);
        }


//        mAdapter = new MoguViewPagerAdapter(mViewList, getContext());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTransforView.transfor(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
