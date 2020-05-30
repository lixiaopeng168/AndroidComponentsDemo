package com.example.user

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.BaseActivity
import com.example.common.utils.RouteBuildPath

@Route(path = RouteBuildPath.userActivity)
class UserActivity : BaseActivity(){
    override fun initEvents() {
    }

    override fun initDatas() {
    }

    override fun initViews() {
    }

    override fun getContentView(): Int {
        return R.layout.activity_user
    }

}