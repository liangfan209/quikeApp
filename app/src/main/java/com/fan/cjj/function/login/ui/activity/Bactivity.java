package com.fan.cjj.function.login.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.cjj.R;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28/028
 * 版权：
 */
@Route(path = "/app2/activity")
public class Bactivity extends BaseUiAcitivty {
    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_b;
    }

    @Override
    protected void attach() {

    }
}
