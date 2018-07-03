package com.hangzhou.myrecyclerviewinmvp.ui.mobileApp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hangzhou.myrecyclerviewinmvp.R;
import com.hangzhou.myrecyclerviewinmvp.adapter.MobileAppAdapter;
import com.hangzhou.myrecyclerviewinmvp.utils.ToastUtil;


/**
 * @author 作者：hugo
 * @date 时间：2018/6/8.
 * 版本：v1.0
 * 描述：应用列表
 */
public class MobileAppFragment extends Fragment implements MobileAppContract.MobileAppView{
    /**传入值的key*/
    public static final String INPUT_TYPE_KEY = "input_type_key";

    private int type = 1;

    private RecyclerView recyclerView;
    private MobileAppAdapter mAdapter;

    private MobileAppPersenter persenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mobile_app,container,false);
        initialize(view);
        return view;
    }


    private void initialize(View view) {
        if (getArguments() != null) {
            type = getArguments().getInt(INPUT_TYPE_KEY,1);
        }
        recyclerView = view.findViewById(R.id.recyclerView);
        persenter = new MobileAppPersenter();
        persenter.attachView(this);
        persenter.setType(type);
        mAdapter = new MobileAppAdapter(persenter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()) );
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.detachView();
    }

    @Override
    public void showLoading() {
        showToast("开始Loading");
    }

    @Override
    public void hideLoading() {
        showToast("隐藏Loading");
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToast(getContext(),msg);
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @Override
    public Context getContext1() {
        return getContext();
    }

    @Override
    public void showItem() {
        if(mAdapter != null){
            mAdapter.notifyDataSetChanged();
        }
    }
}
