package com.fan.cjj.function.login.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.cjj.R;
import com.fan.cjj.test.TestObject;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28/028
 * 版权：
 */
@Route(path = "/app1/activity")
public class Aactivity extends BaseUiAcitivty {

    @Autowired(name = "yoyo")
    TestObject str;


    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_a;
    }

    @Override
    protected void attach() {
        ARouter.getInstance().inject(this);
    }
}
