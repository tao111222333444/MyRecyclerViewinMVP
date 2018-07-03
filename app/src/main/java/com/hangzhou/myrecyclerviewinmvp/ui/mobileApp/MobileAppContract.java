package com.hangzhou.myrecyclerviewinmvp.ui.mobileApp;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.hangzhou.myrecyclerviewinmvp.base.BaseContract;
import com.hangzhou.myrecyclerviewinmvp.base.Callback;
import com.hangzhou.myrecyclerviewinmvp.utils.AppInfoUtils;

import java.util.List;

/**
 * @author 作者：hugo
 * @date 时间：2018/7/3.
 * 版本：v1.0
 * 描述：
 */
public interface MobileAppContract {

   interface MobileAppModel extends BaseContract.BaseModel{
        void getApplication(Context context, int type, Callback<List<AppInfoUtils.Application>> callback);
    }

    interface MobileAppView extends BaseContract.BaseView{

        /**
         *  获取  上下文环境
         * @return
         */
        Context getContext1();

        /***
         * 刷新列表
         */
        void  showItem();

    }

    /**
     * 这个接口是用来给RecycleView item  使用的
     */
    interface MobileAppItemView{
        /**
         * 设置应用名
         * @param applicationName
         */
        void setApplicationName(String applicationName);

        /**
         * 设置应用包名
         * @param packageName
         */
        void setPackageName(String packageName);

        /**
         * 设置应用图标
         * @param applicationIcon
         */
        void setApplicationIcon(Drawable applicationIcon);

        /**
         * 设置版本号
         * @param version
         */
        void setVersion(String version);
    }


   abstract class AbstractMobileAppPresenter extends BaseContract.BasePresenter<MobileAppView,MobileAppModel> {

        /**
         * 设置要获取的应用类型
         * @param type
         */
        public abstract void setType(int type);

        /**
         * 用于recycleView Item的显示赋值
         */
        public abstract void onBindMobileAppItemViewAtPosition(int position, MobileAppItemView mobileAppItemView);

        /**
         * 返回数据个数
         * @return
         */
        public abstract int getMobileAppItemCount();


    }

}
