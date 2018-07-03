package com.hangzhou.myrecyclerviewinmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hangzhou.myrecyclerviewinmvp.ui.mobileApp.MobileAppActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        MobileAppActivity.show(this);
    }
}
