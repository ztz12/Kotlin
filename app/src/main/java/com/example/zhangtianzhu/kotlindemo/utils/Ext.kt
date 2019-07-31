package com.example.zhangtianzhu.kotlindemo.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.Toast

private var toast: Toast? = null

class AlphaUtils {
    companion object {
        fun backgroundAlpha(activity: Activity, alpha: Float) {
            val lp: WindowManager.LayoutParams = activity.window.attributes
            lp.alpha = alpha
            if (alpha == 1.0f) {
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            } else {
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            }
            activity.window.attributes = lp
        }

        fun dpToPx(value: Float, activity: Activity): Float {
            val scale = activity.resources.displayMetrics.density
            return value * scale + 0.5f
        }
    }
}

@SuppressLint("ShowToast")
class ToastUtils {
    companion object {
        //只有在主线程，才会弹出吐司，否则吐司不显示
        fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (toast == null) {
                    toast = Toast.makeText(KotlinInit.getContext(), msg, duration)
                } else {
                    toast?.setText(msg)
                }
                toast?.show()
            }
        }

        //在任何线程吐司都能弹出，通过handler切换到主线程
        fun showToastOnUi(msg: String, duration: Int = Toast.LENGTH_SHORT) {
            KotlinInit.getHandler().post {
                if (toast == null) {
                    toast = Toast.makeText(KotlinInit.getContext(), msg, duration)
                } else {
                    toast?.setText(msg)
                }
                toast?.show()
            }
        }
    }
}

//Handler扩展类,扩展函数  如果该函数声明内联，那么参数中的lambda也是内联函数
inline fun Handler.postDelay(delayMillis: Long, crossinline action: () -> Unit): Runnable {
    val runnable = Runnable { action() }
    postDelayed(runnable, delayMillis)
    return runnable
}

inline fun View.postDelay(delayMillis: Long, crossinline action: () -> Unit): Runnable {
    val runnable = Runnable { action() }
    postDelayed(runnable, delayMillis)
    return runnable
}


