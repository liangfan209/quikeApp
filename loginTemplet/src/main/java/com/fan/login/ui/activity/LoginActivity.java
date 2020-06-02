package com.fan.login.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fan.baseuilibrary.configration.AppArouter;
import com.fan.baseuilibrary.utils.AccountValidatorUtil;
import com.fan.baseuilibrary.utils.EditFormatUtils;
import com.fan.baseuilibrary.utils.Utils;
import com.fan.baseuilibrary.view.DeletableEditText;
import com.fan.login.R;
import com.fan.login.R2;
import com.fan.login.bean.LoginInfo;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = AppArouter.TEMPLTE_LOGIN)
public class LoginActivity extends BaseLoginUiActivity {

    @BindView(R2.id.tv_welcom)
    TextView mTvWelcom;
    @BindView(R2.id.et_phone)
    DeletableEditText mEtPhone;
    @BindView(R2.id.et_pwd)
    DeletableEditText mEtPwd;
    @BindView(R2.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R2.id.tv_login)
    TextView mTvLogin;
    @BindView(R2.id.tv_protocol1)
    TextView mTvProtocol1;
    @BindView(R2.id.tv_protocol2)
    TextView mTvProtocol2;

    @Override
    protected int getContentViewLayout() {
        return R.layout.login_activity_login;
    }

    @Override
    protected void attach() {
        super.attach();
        EditFormatUtils.phoneNumAddSpace(mEtPhone);
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
    }


    @OnClick({R2.id.tv_forget_pwd, R2.id.tv_login})
    public void onViewClicked(View view) {
        if(view.getId() == R.id.tv_login){
            login();
        }else if(view.getId() == R.id.tv_forget_pwd){
            ARouter.getInstance().build(AppArouter.TEMPLTE_FORGET_PWD)
                    .withSerializable(AppArouter.LOGIN_BUNDLE,mLoginModel).navigation();
        }
    }
}
