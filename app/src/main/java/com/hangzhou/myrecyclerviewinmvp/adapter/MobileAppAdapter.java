package com.hangzhou.myrecyclerviewinmvp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hangzhou.myrecyclerviewinmvp.R;
import com.hangzhou.myrecyclerviewinmvp.ui.mobileApp.MobileAppContract;
import com.hangzhou.myrecyclerviewinmvp.viewHolder.MobileHolder;

/**
 * @author 作者：hugo
 * @date 时间：2018/6/8.
 * 版本：v1.0
 * 描述：
 */
public class MobileAppAdapter extends RecyclerView.Adapter<MobileHolder>{

    private final MobileAppContract.AbstractMobileAppPresenter presenter;

    public MobileAppAdapter(MobileAppContract.AbstractMobileAppPresenter mobileAppPresenter) {
        this.presenter = mobileAppPresenter;
    }
    @NonNull
    @Override
    public MobileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MobileHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_mobile_app_fragment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MobileHolder holder, int position) {
        //传入的虽然是  MobileHolder  但是这个函数接收的是MobileAppItemView
        presenter.onBindMobileAppItemViewAtPosition(position,holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getMobileAppItemCount();
    }
}
