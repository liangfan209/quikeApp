package com.fan.cjj.login.mvp.p;

import com.fan.base_library.http.BaseBean;
import com.fan.base_library.http.BaseSubscriber;
import com.fan.base_library.mvp.BaseModel;
import com.fan.cjj.bean.LoginInfo;
import com.fan.cjj.login.mvp.v.LoginIView;
import com.fan.cjj.utils.ApiServiceUtils;

/**
 * 文件名：
 * 描述：
 * 作者：梁帆
 * 时间：2020/5/28
 * 版权：
 */
public class LoginPresenter {
    private LoginIView mIView;
    private BaseModel mBaseModel = new BaseModel();

    public LoginPresenter(LoginIView IView) {
        mIView = IView;
    }

    public void login(String api,String name,String pwd){
        mIView.loginView(null);
//        mBaseModel.exeHttp(ApiServiceUtils.getApiService().hhrLogin(api,name,pwd))
//                .subscribe(new BaseSubscriber<BaseBean<LoginInfo>>(mIView) {
//                    @Override
//                    public void result(BaseBean<LoginInfo> baseBean) {
//                        mIView.loginView(baseBean.getResult());
//                    }
//                });
    }

    public void register(String api,String name,String pwd){
        mBaseModel.exeHttp(ApiServiceUtils.getApiService().register(api,name,pwd))
                .subscribe(new BaseSubscriber<BaseBean<LoginInfo>>(mIView) {
                    @Override
                    public void result(BaseBean<LoginInfo> baseBean) {
                        mIView.registerView();
                    }
                });
    }

}
