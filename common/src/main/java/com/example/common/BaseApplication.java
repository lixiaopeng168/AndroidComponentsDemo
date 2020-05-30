package com.example.common;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initRoute();
    }

    private void initRoute() {
        if (NBConstant.isDebugARouter) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
