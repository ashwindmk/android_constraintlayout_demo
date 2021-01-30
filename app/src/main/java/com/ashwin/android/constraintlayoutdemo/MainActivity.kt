package com.ashwin.android.constraintlayoutdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openGuidelineActivity(view: View) {
        startActivity(Intent(this, GuidelineActivity::class.java))
    }

    fun openBarrierActivity(view: View) {
        startActivity(Intent(this, BarrierActivity::class.java))
    }

    fun openDynamicActivity(view: View) {
        startActivity(Intent(this, DynamicActivity::class.java))
    }

    fun exit(view: View) {
        finish()
    }
}
