package com.fan.cjj;

import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.cjj.bean.UserInfo;
import com.fan.cjj.mine.mvp.p.LoginPresenter;
import com.fan.cjj.mine.mvp.v.MoreInter;

public class MainActivity extends BaseUiAcitivty<UserInfo> implements MoreInter<UserInfo> {

    private LoginPresenter mLoginPresenter;

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void attach() {
        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.login("partner.account.login","18942923127","123456");
    }

    @Override
    public void updateView(UserInfo data) {

    }

    @Override
    public void getfun1() {

    }

    @Override
    public void getFun2() {

    }
}
