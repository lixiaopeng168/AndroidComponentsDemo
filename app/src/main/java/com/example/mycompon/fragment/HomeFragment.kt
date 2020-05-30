package com.example.mycompon.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.BaseFragment
import com.example.common.utils.RouteBuildPath
import com.example.mycompon.R
import kotlinx.android.synthetic.main.fragment_home.*

@Route(path = RouteBuildPath.mainHomeFragment)
class HomeFragment : BaseFragment() {
    override fun getContentView(): Int {
        return R.layout.fragment_home
    }

    override fun initViews() {
        fragmentHomeText.text = "这个是HomeFragment"
    }
    override fun initEvents() {}
    override fun initDatas() {}
}