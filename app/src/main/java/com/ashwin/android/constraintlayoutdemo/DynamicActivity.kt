package com.ashwin.android.constraintlayoutdemo

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_dynamic.*

fun Int.resolvedColor(context: Context): Int = ContextCompat.getColor(context, this)

class DynamicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        //inflate()
        addFragment()
    }

    fun addFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentContainer,
                DynamicFragment.newInstance(
                    //intent.getParcelableExtra(EXTRA_CALL_INFO),
                    //intent.getStringExtra(EXTRA_AOSP_UNIQUE_CALL_ID)
                ), "dyn-frag")
            .commit()
    }

    fun inflate() {
        //id = View.generateViewId()

        val oneView = findViewById<TextView>(R.id.one_textview)
        val twoView = findViewById<TextView>(R.id.two_textview)
        val threeView = findViewById<TextView>(R.id.three_textview)
        //val swipeIcon = findViewById<ImageView>(R.id.swipe_icon)

        oneView.text = "ONE VIEW"
        twoView.text = "TWO VIEW"
        threeView.text = "THREE VIEW"

//        val color = R.color.colorAccent
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            swipeIcon.imageTintList = ColorStateList.valueOf(color.resolvedColor(swipeIcon.context))
//        }

        val viewIds = arrayOf(threeView.id, oneView.id, twoView.id)

        val root = findViewById<ConstraintLayout>(R.id.root_layout)

        alignElementsTop(root, viewIds)
    }

    fun alignElementsTop(constraintLayout: ConstraintLayout, viewIds: Array<Int>) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(viewIds[0], ConstraintSet.TOP, R.id.topGuideline, ConstraintSet.BOTTOM)
        constraintSet.clear(viewIds[0], ConstraintSet.BOTTOM)
        for (i in 1 until viewIds.size) {
            constraintSet.connect(viewIds[i], ConstraintSet.TOP, viewIds[i - 1], ConstraintSet.BOTTOM)
            constraintSet.clear(viewIds[i], ConstraintSet.BOTTOM)
        }
        constraintSet.applyTo(constraintLayout)

//        if (constraintLayout is VyngSmartView) {
//            constraintLayout.isNa = true
//        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            showFullScreen()
        }
    }
}