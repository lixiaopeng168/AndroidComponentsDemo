package com.example.mycompon

import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.BaseActivity
import com.example.common.utils.RouteBuildPath
import com.example.mycompon.fragment.HomeFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouteBuildPath.mainActivity)
class MainActivity : BaseActivity(), TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {


    private var lastIndex = 0

    override fun getContentView(): Int {
        return R.layout.activity_main
    }


    override fun initViews() {
        initTab()
        initFragment()
    }

    private fun initTab() {
        mainTab.addTab(mainTab.newTab().setText("首页"))
        mainTab.addTab(mainTab.newTab().setText("我的"))
    }

    private fun initFragment() {
//        val bt = supportFragmentManager.beginTransaction()
//        val  f =  ARouter.getInstance().build(RouteBuildPath.mainHomeFragment).navigation() as Fragment?
//        if (f != null) {
//            bt.replace(R.id.mainContain, f).commit()
//        }
        toggleFragment(RouteBuildPath.mainHomeFragment)
        lastIndex = 0
    }

    override fun initEvents() {
        mainTab.addOnTabSelectedListener(this)
        mainButton.setOnClickListener {
            ARouter.getInstance().build(RouteBuildPath.userActivity).navigation()
        }
    }

    override fun initDatas() {

    }

    override fun onTabReselected(p0: TabLayout.Tab?) {
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        val p = tab?.position
//        Log.i("route","tab:$p")
        if (lastIndex != p) {
            when (p) {
                0 -> {
                    //首页
                    toggleHome()
                }
                1 -> {
                    //我的
                    toggleMine()
                }
            }
            lastIndex = p!!
        }

    }

    //首页
    private fun toggleHome(){
        toggleFragment(RouteBuildPath.mainHomeFragment)
    }
    //我的
    private fun toggleMine(){
//        toggleFragment(RouteBuildPath.mainMineFragment)
        val bt = supportFragmentManager.beginTransaction()
        val f =  ARouter.getInstance().build(RouteBuildPath.mainMineFragment).
            withString("routerString","这是个string字符串传值测试，支持其他数据类型、bundle和parcelable等方式").
//            withInt("routerInt",100).
        navigation() as Fragment?
        bt.replace(R.id.mainContain,f!!).commit()
    }

    //用route切换
    private fun toggleFragment(path:String){
        val bt = supportFragmentManager.beginTransaction()
        val f =  ARouter.getInstance().build(path).navigation() as Fragment?
        bt.replace(R.id.mainContain,f!!).commit()
    }

}
