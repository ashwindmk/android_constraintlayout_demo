package com.ashwin.android.constraintlayoutdemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowInsets
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline
import androidx.core.view.marginTop

class CustomLayout(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    val topGuideline: Guideline

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.layout_custom, this, true)

        topGuideline = findViewById(R.id.topGuideline)

        inflate()
    }

    fun inflate() {
        id = View.generateViewId()

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

        //val root = findViewById<ConstraintLayout>(R.id.root_layout)

        alignElementsTop(this, viewIds)
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

    override fun onApplyWindowInsets(insets: WindowInsets?): WindowInsets {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            Log.d("constraint-debug", "onApplyWindowInsets: insets: ${rootWindowInsets?.displayCutout}")
//            Log.d("constraint-debug", "topguideline: current top: ${topGuideline.gett}")
//            topGuideline.setGuidelineBegin()
            //topGuideline.setGuidelineBegin(500)
        }
        return super.onApplyWindowInsets(insets)
    }

    override fun onAttachedToWindow() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                Log.d("constraint-debug", "onAttachedToWindow: ${rootWindowInsets?.displayCutout}")
            }
        }
        super.onAttachedToWindow()
    }
}