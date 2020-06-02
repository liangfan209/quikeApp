package com.fan.cjj.function.login.mvp.p;

import com.fan.cjj.function.login.mvp.v.LoginIView;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class LoginPresenter {
    private LoginIView mIView;

    public LoginPresenter(LoginIView IView) {
        mIView = IView;
    }

    public void login(String api,String name,String pwd){
        mIView.loginView(null);
    }


}
