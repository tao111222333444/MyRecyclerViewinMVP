package com.hangzhou.myrecyclerviewinmvp.ui.mobileApp;

import com.hangzhou.myrecyclerviewinmvp.base.Callback;
import com.hangzhou.myrecyclerviewinmvp.utils.AppInfoUtils;

import java.util.List;

/**
 * @author 作者：hugo
 * @date 时间：2018/7/3.
 * 版本：v1.0
 * 描述：app列表的  Persenter   MVP 中的P层
 */
public  class MobileAppPersenter extends MobileAppContract.AbstractMobileAppPresenter{
    List<AppInfoUtils.Application> list;


    @Override
    public void setType(int type) {
        view.showLoading();
        model.getApplication(view.getContext1(), type, new Callback<List<AppInfoUtils.Application>>() {
            @Override
            public void onSuccess(List<AppInfoUtils.Application> data) {
                list = data;
                view.showItem();
                view.showToast("成功了");
            }

            @Override
            public void onFailure(String msg) {
                view.showError(msg);
            }

            @Override
            public void onError() {
                view.showError("获取失败");
            }

            @Override
            public void onComplete() {
                view.hideLoading();
            }
        });
    }

    /**
     * 调用接口去设置值 而不是直接调用具体的实现
     * @param position
     * @param mobileAppItemView
     */
    @Override
    public void onBindMobileAppItemViewAtPosition(int position, MobileAppContract.MobileAppItemView mobileAppItemView) {
        AppInfoUtils.Application application = list.get(position);
        mobileAppItemView.setApplicationIcon(application.getApplicationIcon());
        mobileAppItemView.setPackageName(application.getPackageName());
        mobileAppItemView.setApplicationName(application.getApplicationName());
        mobileAppItemView.setVersion(application.getVersion());
    }

    @Override
    public int getMobileAppItemCount() {
        return list.size();
    }

    @Override
    protected MobileAppContract.MobileAppModel createModel() {
        return new MobileAppModel();
    }
}
