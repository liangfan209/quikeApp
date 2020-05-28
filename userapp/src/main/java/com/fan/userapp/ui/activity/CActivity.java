package com.fan.userapp.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.userapp.R;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28/028
 * 版权：
 */
@Route(path = "/userapp/CActivity")
public class CActivity extends BaseUiAcitivty {
    @Override
    protected int getContentViewLayout() {
        return R.layout.userapp_activity_c;
    }

    @Override
    protected void attach() {

    }
}
