package com.fan.cjj.function.main;

import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
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
//            TabLayout.Tab tab = mTablayout.newTab();
//            View cView = LayoutInflater.from(this).inflate(R.layout.main_tab_view, null);
//            cView.setLayoutParams(new LinearLayout.LayoutParams(Utils.dp2px(120), FrameLayout.LayoutParams.MATCH_PARENT));
//            TextView tv = cView.findViewById(R.id.tv_tab);
//            tv.setText(str);
//            tab.setCustomView(cView);
//            mTablayout.addTab(tab);

            mTablayout.addTab(mTablayout.newTab().setText(str));
        }
    }
}
