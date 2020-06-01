package com.fan.cjj.function.main;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.baseuilibrary.utils.Utils;
import com.fan.cjj.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/29
 * 版权：
 */
@Route(path = "/app/MainActivity")
public class MainActivity extends BaseUiAcitivty {

    @BindView(R.id.flt_content)
    FrameLayout mFltContent;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    private String[] tabs = new String[]{"tab1","tab2","tab3"};

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void attach() {
        List<String> strings = Arrays.asList(tabs);
        for (String str: strings) {
            mTablayout.addTab(mTablayout.newTab().setText(str).setIcon(R.mipmap.ic_launcher));
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout mTabStrip = (LinearLayout) mTablayout.getChildAt(0);
        //遍历SlidingTabStrip的所有TabView子view
        for (int i = 0; i < mTabStrip.getChildCount(); i++) {
            View tabView = mTabStrip.getChildAt(i);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)tabView.getLayoutParams();
            //给TabView设置leftMargin和rightMargin
            params.leftMargin = Utils.dp2px(this,30);
            params.rightMargin = Utils.dp2px(this,30);
            tabView.setLayoutParams(params);
            //触发绘制
            tabView.invalidate();
        }

    }
}
