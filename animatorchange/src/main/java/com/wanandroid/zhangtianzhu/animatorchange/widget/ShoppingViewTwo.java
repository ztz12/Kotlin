package com.wanandroid.zhangtianzhu.animatorchange.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.wanandroid.zhangtianzhu.base.BezierUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yif
 */
public class ShoppingViewTwo extends android.support.v7.widget.AppCompatImageView {

    // 缩放动画
    private ObjectAnimator mScaleXAnimator;
    private ObjectAnimator mScaleYAnimator;
    // 旋转动画
    private ObjectAnimator mRotateAnimator;
    // 移动动画
    private ObjectAnimator mTranslateAnimator;

    // 动画集合
    private AnimatorSet mAnimatorSet;

    private AnimatorListener mListener;

    public ShoppingViewTwo(Context context) {
        this(context, null, 0);
    }

    public ShoppingViewTwo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShoppingViewTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setListener(AnimatorListener listener) {
        this.mListener = listener;
    }

    private void init(Context context) {

        mAnimatorSet = new AnimatorSet();

        // X、Y 均缩小1倍
        mScaleYAnimator = ObjectAnimator.ofFloat(this, "scaleY", 1f, 0.8f);
        mScaleYAnimator.setDuration(200);
        mScaleYAnimator.setInterpolator(new AccelerateInterpolator());

        mScaleXAnimator = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0.8f);
        mScaleXAnimator.setDuration(200);
        mScaleXAnimator.setInterpolator(new AccelerateInterpolator());

        // 顺时针旋转 35 度
        mRotateAnimator = ObjectAnimator.ofFloat(this, "rotation", 0, 35);
        mRotateAnimator.setDuration(100);
        mRotateAnimator.setInterpolator(new LinearInterpolator());

    }

    /**
     * 设置坐标
     *
     * @param position
     */
    public void setPosition(PointF position) {
        if (position == null) {
            return;
        }

        setTranslationX(position.x);
        setTranslationY(position.y);
    }

    public void start(PointF startPoint, PointF endPoint) {

        setPosition(startPoint);

        mTranslateAnimator = ObjectAnimator.ofObject(this,
                "position",
                new BezierEvaluator(startPoint, endPoint),
                startPoint,
                endPoint);

        mTranslateAnimator.setDuration(450);
        mTranslateAnimator.setInterpolator(new AccelerateInterpolator());

        mAnimatorSet.play(mScaleYAnimator)
                .with(mScaleXAnimator)
                .before(mRotateAnimator);
        mAnimatorSet.play(mRotateAnimator)
                .before(mTranslateAnimator);
        mAnimatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mListener != null) {
                    mListener.animatorEnd();
                }

                // 将自己移除
                ViewGroup parent = (ViewGroup) ShoppingViewTwo.this.getParent();
                if (parent != null && parent instanceof ViewGroup) {
                    parent.removeView(ShoppingViewTwo.this);
                }

            }
        });

        mAnimatorSet.start();

    }

    /**
     * 动画回调
     */
    public interface AnimatorListener {
        /**
         * 动画结束
         */
        void animatorEnd();
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
    private static class BezierEvaluator implements TypeEvaluator<PointF> {

        private final List<PointF> pointList;

        public BezierEvaluator(PointF startPoint, PointF endPoint) {
            this.pointList = new ArrayList<>();

            PointF controlPointF = new PointF(endPoint.x, startPoint.y);

            pointList.add(startPoint);
            pointList.add(controlPointF);
            pointList.add(endPoint);

        }

        @Override
        public PointF evaluate(float fraction, PointF startPoint, PointF endPoint) {
            return new PointF(BezierUtils.calculatePointCoordinate(BezierUtils.X_TYPE, fraction, 2, 0, pointList),
                    BezierUtils.calculatePointCoordinate(BezierUtils.Y_TYPE, fraction, 2, 0, pointList));
        }
    }

}