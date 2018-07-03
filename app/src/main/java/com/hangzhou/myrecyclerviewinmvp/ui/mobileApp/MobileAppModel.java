package com.hangzhou.myrecyclerviewinmvp.ui.mobileApp;

import android.content.Context;

import com.hangzhou.myrecyclerviewinmvp.base.Callback;
import com.hangzhou.myrecyclerviewinmvp.utils.AppInfoUtils;

import java.util.List;

/**
 * @author 作者：hugo
 * @date 时间：2018/7/3.
 * 版本：v1.0
 * 描述：MVP 中的M层  用于获取数据
 */
public class MobileAppModel implements  MobileAppContract.MobileAppModel{
    /**全部应用*/
    public static final int TYPE_1 = 1;
    /**系统应用*/
    public static final int TYPE_2 = 2;
    /**非系统应用*/
    public static final int TYPE_3 = 3;
    @Override
    public void getApplication(Context context, int type, Callback<List<AppInfoUtils.Application>> callback) {
        List<AppInfoUtils.Application> list;
        switch (type){
            case TYPE_1:
                list = AppInfoUtils.getAllApplication(context);
                break;
            case TYPE_2:
                list = AppInfoUtils.getAllSystemApplication(context);
                break;
            case TYPE_3:
                list = AppInfoUtils.getAllNonSystemApplication(context);
                break;
            default:
                list = AppInfoUtils.getAllApplication(context);
        }
        callback.onSuccess(list);
        callback.onComplete();
    }
}
