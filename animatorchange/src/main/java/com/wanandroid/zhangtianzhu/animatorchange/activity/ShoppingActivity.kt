package com.wanandroid.zhangtianzhu.animatorchange.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.PointF
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.wanandroid.zhangtianzhu.animatorchange.R
import com.wanandroid.zhangtianzhu.animatorchange.widget.ShoppingView
import com.wanandroid.zhangtianzhu.animatorchange.widget.ShoppingViewTwo
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity(), ShoppingViewTwo.AnimatorListener {

    /**
     * 缩放动画
     */
    private lateinit var mScaleXAnimation: ObjectAnimator
    private lateinit var mScaleYAnimation: ObjectAnimator

    private lateinit var mAnimatorSet: AnimatorSet

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        //购物车中添加数量变化动画
        mScaleXAnimation = ObjectAnimator.ofFloat(tv_dot, "scaleX", 1f, 1.2f, 1f, 1.1f, 1f)
        mScaleYAnimation = ObjectAnimator.ofFloat(tv_dot, "scaleY", 1f, 1.2f, 1f, 1.1f, 1f)
        mAnimatorSet = AnimatorSet()
        mAnimatorSet.play(mScaleXAnimation).with(mScaleYAnimation)

        tv_add.setOnClickListener {
            val iconPos = getScreenPointF(iv_icon)
            val cartPos = getScreenPointF(iv_shopping_cart)

            val view = ShoppingViewTwo(this)

            view.setListener(this)
            //设置view内容
            view.setImageBitmap((iv_icon.drawable as BitmapDrawable).bitmap)
            //设置view尺寸
            val layoutParams = LinearLayout.LayoutParams(iv_icon.width, iv_icon.height)
            view.layoutParams = layoutParams

            //添加到窗体中
            val decorView = this.window.decorView as ViewGroup
            decorView.addView(view)

            view.start(iconPos, cartPos)
        }
    }

    /**
     * 获取屏幕绝对坐标
     */
    private fun getScreenPointF(view: View): PointF {
        val location = IntArray(2)

        view.getLocationOnScreen(location)
        return PointF(location[0].toFloat(), location[1].toFloat())
    }


    override fun animatorEnd() {
        addCount()
        iv_shopping_cart.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.shopping_cart_full))
    }

    private fun addCount() {
        ++count
        if (count <= 0) {
            return
        }

        if (mAnimatorSet.isRunning) {
            mAnimatorSet.cancel()
        }

        mAnimatorSet.start()
        tv_dot.visibility = View.VISIBLE
        tv_dot.text = count.toString()
    }
}
