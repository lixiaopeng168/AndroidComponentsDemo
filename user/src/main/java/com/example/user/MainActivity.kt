package com.example.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.utils.RouteBuildPath

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.userClick).setOnClickListener {
            ARouter.getInstance().build(RouteBuildPath.userActivity).navigation()
        }
    }
}
