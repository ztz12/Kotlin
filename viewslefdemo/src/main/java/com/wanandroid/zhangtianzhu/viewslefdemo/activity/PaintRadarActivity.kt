package com.wanandroid.zhangtianzhu.viewslefdemo.activity

import android.graphics.Matrix
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import com.wanandroid.zhangtianzhu.viewslefdemo.R
import java.util.*

class PaintRadarActivity : AppCompatActivity() {
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint_radar)
//        testMatrix()
    }

    private fun testMatrix() {
        //matrix表示坐标映射与数值变换
        //矩阵做乘法运算，只有左边矩阵的列数与右边矩阵的行数相等，才能做乘法，否则无法做乘法，也就没有意义
        //初始化三个点(0,0,)、(200,400)、(500,1000)
        val psts = floatArrayOf(0f, 0f, 200f, 400f, 500f, 1000f)
        //初始化单位矩阵
        //单位值为{[1,0,0],[0,1,0],[0,0,1]}每个数组组合元素表示矩阵的每一行
        /**
         * 单位矩阵 ,1与1交叉表示缩放，默认为1不缩放,a[0][1]与a[1][0]表示错切,a[2][0]与a[1][2]表示位移,最下面一行表示透视，用在矩阵的camera上,默认为[0,0,1]
         *  1 0 0
         *  0 1 0
         *  0 0 1
         *
         */
        val matrixTest = Matrix()
        //每个点进行缩放
        matrixTest.setScale(0.5f, 0.5f)
//        matrixTest.mapPoints(psts)
        val dst = FloatArray(6)
        //各参数为：目标数据，目标数据起始点，原数据，原数据起始点，几个点：2个点包含四个数值
        matrixTest.mapPoints(dst, 0, psts, 2, 2)
        //位移操作为x+100f,y+100f,以下三种位移变换操作结果都不同
        //直接将坐标位移100
        matrixTest.setTranslate(100f, 100f)
        //先将坐标缩放0.5然后再位移100
        matrixTest.postTranslate(100f, 100f)
        //位移也被缩放了0.5倍，所以位移变成了50，结果就是先缩放0.5再位移50
        matrixTest.preTranslate(100f, 100f)
        matrixTest.mapPoints(dst)
        showToast(Arrays.toString(dst))
    }

    fun showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (toast == null) {
                toast = Toast.makeText(this, msg, duration)
            } else {
                toast?.setText(msg)
            }
            toast?.show()
        }
    }
}
