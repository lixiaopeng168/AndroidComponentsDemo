package com.example.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ARouter.getInstance().inject(this);
        initViews();
        initEvents();
        initDatas();
    }



    protected abstract int getContentView() ;
    protected abstract void initViews();
    protected abstract void initEvents();
    protected abstract void initDatas();



}
