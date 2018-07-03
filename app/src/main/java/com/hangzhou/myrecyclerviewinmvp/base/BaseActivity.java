package com.hangzhou.myrecyclerviewinmvp.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.hangzhou.myrecyclerviewinmvp.utils.ToastUtil;


/**
 * 基类activity
 * @author 29794
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    protected static void show(Context context, Class<?> cls){
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
    }

}
