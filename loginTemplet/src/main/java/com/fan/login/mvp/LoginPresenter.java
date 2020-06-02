package com.fan.login.mvp;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class LoginPresenter {
    private LoginIView mIView;
    private LoginModel mLoginModel;

    public LoginPresenter(LoginIView IView, LoginModel loginModel) {
        mIView = IView;
        this.mLoginModel = loginModel;
    }

    public void login(String api, String name, String pwd) {
        mLoginModel.login(api, name, pwd, mIView);
    }

    public void getVertificatCode(String api, String type, String phone) {
        mLoginModel.getVertificatCode(api, type, phone, mIView);
    }

    public void forgetPwd(String api, String phone, String pwd, String checkCode) {
        mLoginModel.forgetPwd(api, phone, pwd, checkCode, mIView);
    }

}
