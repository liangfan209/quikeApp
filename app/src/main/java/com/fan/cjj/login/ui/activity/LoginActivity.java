package com.fan.cjj.login.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fan.baseuilibrary.ui.BaseUiAcitivty;
import com.fan.baseuilibrary.utils.AccountValidatorUtil;
import com.fan.baseuilibrary.utils.EditFormatUtils;
import com.fan.baseuilibrary.utils.Utils;
import com.fan.baseuilibrary.view.DeletableEditText;
import com.fan.cjj.R;
import com.fan.cjj.bean.LoginInfo;
import com.fan.cjj.login.mvp.p.LoginPresenter;
import com.fan.cjj.login.mvp.v.LoginIView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseUiAcitivty implements LoginIView {

    @BindView(R.id.tv_welcom)
    TextView mTvWelcom;
    @BindView(R.id.et_phone)
    DeletableEditText mEtPhone;
    @BindView(R.id.et_pwd)
    DeletableEditText mEtPwd;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_protocol1)
    TextView mTvProtocol1;
    @BindView(R.id.tv_protocol2)
    TextView mTvProtocol2;
    private LoginPresenter mLoginPresenter;

    @Override
    protected int getContentViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void attach() {
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);
        EditFormatUtils.phoneNumAddSpace(mEtPhone);
    }

    @OnClick({R.id.tv_forget_pwd, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_pwd:
                break;
            case R.id.tv_login:
                login();
                break;
        }
    }

    private void login() {
        String phoneNumber = mEtPhone.getText().toString().replaceAll(" ", "").trim();
        if (!AccountValidatorUtil.isMobile(phoneNumber)) {
            Utils.showToast(this, "请输入正确的手机号码");
            return;
        }
        String pwd = mEtPwd.getText().toString().trim();
        pwd = Utils.md5(pwd);
        mLoginPresenter.login("partner.account.login", phoneNumber, pwd);
    }

    @Override
    public void loginView(LoginInfo info) {
        Utils.showToastOk(this, "登陆成功");
        ARouter.getInstance().build("/userapp/UserActivity").navigation();
    }
}
