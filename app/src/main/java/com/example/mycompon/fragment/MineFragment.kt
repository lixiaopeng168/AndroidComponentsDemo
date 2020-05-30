package com.example.mycompon.fragment

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.BaseFragment
import com.example.common.utils.RouteBuildPath
import com.example.mycompon.R
import kotlinx.android.synthetic.main.fragment_home.*

@Route(path = RouteBuildPath.mainMineFragment)
class MineFragment : BaseFragment(){

    @JvmField
    @Autowired(name = "routerString")
    var name : String ?= null

//    @JvmField
//    @Autowired(name = "routerInt")
//    var age : Int ?= null

    override fun initViews() {
        ARouter.getInstance().inject(this)
        fragmentHomeText.text = "这个是mineFragment \b router传值:$name   "
    }

    override fun initEvents() {
    }

    override fun getContentView(): Int {
        return R.layout.fragment_home
    }

    override fun initDatas() {
    }

}