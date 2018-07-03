package com.hangzhou.myrecyclerviewinmvp.viewHolder;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hangzhou.myrecyclerviewinmvp.R;
import com.hangzhou.myrecyclerviewinmvp.ui.mobileApp.MobileAppContract;

/**
 * @author 作者：hugo
 * @date 时间：2018/7/3.
 * 版本：v1.0
 * 描述：这个是   RecycleView 的holder
 */
public class MobileHolder extends RecyclerView.ViewHolder implements MobileAppContract.MobileAppItemView{
    ImageView appIcon;
    TextView tvAppName;
    TextView tvAppPackageName;
    TextView tvAppVersion;

    public MobileHolder(View itemView) {
        super(itemView);
        appIcon = itemView.findViewById(R.id.iv_app_icon);
        tvAppName = itemView.findViewById(R.id.tv_app_name);
        tvAppPackageName = itemView.findViewById(R.id.tv_app_package_name);
        tvAppVersion = itemView.findViewById(R.id.tv_app_version);
    }



    @Override
    public void setApplicationName(String applicationName) {
        tvAppName.setText(applicationName);
    }

    @Override
    public void setPackageName(String packageName) {
        tvAppPackageName.setText(packageName);
    }

    @Override
    public void setApplicationIcon(Drawable applicationIcon) {
        appIcon.setImageDrawable(applicationIcon);
    }

    @Override
    public void setVersion(String version) {
        tvAppVersion.setText(version);
    }

}
