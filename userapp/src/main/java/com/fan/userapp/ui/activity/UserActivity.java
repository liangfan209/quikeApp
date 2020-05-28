package com.fan.userapp.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.userapp.R;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28/028
 * 版权：
 */
@Route(path = "/userapp/UserActivity")
public class UserActivity extends BaseUiAcitivty {
    @Override
    protected int getContentViewLayout() {
        return R.layout.userapp_activity_userinfo;
    }

    @Override
    protected void attach() {
        findViewById(R.id.btClick).setOnClickListener(v->{
            ARouter.getInstance().build("/userapp/CActivity").navigation();
        });
    }
}
