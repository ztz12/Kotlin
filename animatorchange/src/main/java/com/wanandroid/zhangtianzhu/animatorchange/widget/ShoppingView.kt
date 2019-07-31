package com.wanandroid.zhangtianzhu.animatorchange.widget

import android.animation.*
import android.content.Context
import android.graphics.PointF
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import com.wanandroid.zhangtianzhu.base.BezierUtils
import java.util.ArrayList

class ShoppingView(context: Context, attributeSet: AttributeSet?) : AppCompatImageView(context, attributeSet) {
    /**
     * 缩放动画
     */
    private lateinit var mScaleXAnimation: ObjectAnimator
    private lateinit var mScaleYAnimation: ObjectAnimator

    /**
     * 旋转动画
     */
    private lateinit var mRotateAnimator: ObjectAnimator

    /**
     * 位移动画
     */
    private lateinit var mTranslateAnimator: ObjectAnimator

    private lateinit var mAnimatorSet: AnimatorSet

    private var mListener: AnimatorListener? = null

    init {
        mAnimatorSet = AnimatorSet()
        mScaleXAnimation = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0.8f)
        mScaleXAnimation.duration = 200
        mScaleXAnimation.interpolator = AccelerateInterpolator()

        mScaleYAnimation = ObjectAnimator.ofFloat(this, "scaleY", 1f, 0.8f)
        mScaleYAnimation.duration = 200
        mScaleYAnimation.interpolator = AccelerateInterpolator()

        mRotateAnimator = ObjectAnimator.ofFloat(this, "rotation", 0f, 35f)
        mRotateAnimator.duration = 100
        mRotateAnimator.interpolator = LinearInterpolator()
    }

    fun setListener(listener: AnimatorListener) {
        this.mListener = listener
    }

    /**
     * 设置坐标
     */
    private fun setPosition(position: PointF) {
        if (position == null) {
            return
        }

        translationX = position.x
        translationY = position.y
    }

    public fun start(startPointF: PointF, endPointF: PointF) {
        setPosition(startPointF)

        mTranslateAnimator = ObjectAnimator.ofObject(this,
                "position",
                BezierEvaluator(startPointF, endPointF),
                startPointF, endPointF)
        mTranslateAnimator.duration = 450
        mTranslateAnimator.interpolator = AccelerateInterpolator()

        mAnimatorSet.play(mScaleYAnimation)
                .with(mScaleXAnimation)
                .before(mRotateAnimator)
        mAnimatorSet.play(mRotateAnimator)
                .before(mTranslateAnimator)

        mAnimatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                if (mListener != null) {
                    mListener?.animatorEnd()
                }

                //移除自己
                val parent = this@ShoppingView.parent as ViewGroup
                if (parent != null && parent is ViewGroup) {
                    parent.removeView(this@ShoppingView)
                }
            }
        })
        mAnimatorSet.start()
    }

    public interface AnimatorListener {
        fun animatorEnd()
    }

    /**
     * TimeInterpolator 时间插值器，根据时间的流逝百分比来计算出当前属性改变的百分比，
     * 比如 LinearInterpolator（匀速插值器）,
     * AccelerateInterpolator(加减速插值器，动画两边快，中间慢),
     * DecelerateInterpolator(减速插值器，动画越来越慢)
     *
     *  TypeEvaluator 估值器，根据当前属性的百分比改变来计算改变后的属性值
     *  比如 IntEvaluator(整型属性)
     *  FloatEvaluator(浮点属性)
     *  ArgbEvaluator(Color 属性)
     *  接口TypeEvaluator实现 public T evaluate(float fraction, T startValue, T endValue); 估值小数，开始值，减速值
     *  result = startValue + fraction * (endValue-startValue)
     */
    private class BezierEvaluator(startPoint: PointF, endPoint: PointF) : TypeEvaluator<PointF> {

        private val pointList: MutableList<PointF>

        init {
            this.pointList = ArrayList()

            val controlPointF = PointF(endPoint.x, startPoint.y)

            pointList.add(startPoint)
            pointList.add(controlPointF)
            pointList.add(endPoint)

        }

        override fun evaluate(fraction: Float, startPoint: PointF, endPoint: PointF): PointF {
            return PointF(BezierUtils.calculatePointCoordinate(BezierUtils.X_TYPE, fraction, 2, 0, pointList),
                    BezierUtils.calculatePointCoordinate(BezierUtils.Y_TYPE, fraction, 2, 0, pointList))
        }
    }
}