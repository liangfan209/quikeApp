package com.fan.login.ui.activity;

import com.fan.baseuilibrary.configration.AppArouter;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.login.mvp.LoginIView;
import com.fan.login.mvp.LoginModel;
import com.fan.login.mvp.LoginPresenter;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/6/2
 * 版权：
 */
public abstract class BaseLoginUiActivity extends BaseUiAcitivty implements LoginIView{

    protected LoginPresenter mLoginPresenter;
    protected LoginModel mLoginModel;

    @Override
    protected void attach(){
        mLoginModel = (LoginModel) getIntent().getSerializableExtra(AppArouter.LOGIN_BUNDLE);
        mLoginPresenter = new LoginPresenter(this, mLoginModel);
    }

}
