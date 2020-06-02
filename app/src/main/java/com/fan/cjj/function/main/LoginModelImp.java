package com.fan.cjj.function.main;

import com.fan.base_library.http.BaseBean;
import com.fan.base_library.http.BaseSubscriber;
import com.fan.base_library.mvp.BaseModel;
import com.fan.cjj.utils.ApiServiceUtils;
import com.fan.login.bean.LoginInfo;
import com.fan.login.mvp.LoginIView;
import com.fan.login.mvp.LoginModel;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/6/2
 * 版权：
 */
public class LoginModelImp extends LoginModel {

    private BaseModel mBaseModel = new BaseModel();

    @Override
    public void login(String api, String username, String pwd, LoginIView iview) {
        mBaseModel.exeHttp(ApiServiceUtils.getApiService().hhrLogin(api,username,pwd))
                .subscribe(new BaseSubscriber<BaseBean<LoginInfo>>(iview) {
                    @Override
                    public void result(BaseBean<LoginInfo> baseBean) {
                        iview.loginView(baseBean.getResult());
                    }
                });
    }

    @Override
    public void getVertificatCode(String api, String type, String phone, LoginIView iview) {
        mBaseModel.exeHttp(ApiServiceUtils.getApiService().hhrGetVertificatCode(api,type,phone))
                .subscribe(new BaseSubscriber<BaseBean>(iview) {
                    @Override
                    public void result(BaseBean baseBean) {
                        iview.getVerticalCodeView();
                    }
                });
    }

    @Override
    public void forgetPwd(String api, String phone, String pwd, String verticode, LoginIView iview) {
        mBaseModel.exeHttp(ApiServiceUtils.getApiService().hhrForgetPwd(api,pwd,phone,verticode))
                .subscribe(new BaseSubscriber<BaseBean>(iview) {
                    @Override
                    public void result(BaseBean baseBean) {
                        iview.forgetPwdView();
                    }
                });
    }

}
