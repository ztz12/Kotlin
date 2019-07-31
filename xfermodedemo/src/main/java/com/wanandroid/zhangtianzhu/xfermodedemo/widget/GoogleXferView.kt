package com.wanandroid.zhangtianzhu.xfermodedemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanandroid.zhangtianzhu.xfermodedemo.R

/**
 * Google XferModel 实例 需要在AndroidManifest中增加 *android:hardwareAccelerated="false"*
 * https://blog.csdn.net/iispring/article/details/50472485
 */
class GoogleXferView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private fun makeDstOval(w: Int, h: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        //一种在画布中画bitmap的构造方法，该bitmap是可以改变的
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.run {
            color = resources.getColor(R.color.yellow)
            isAntiAlias = true
        }
        //绘制椭圆，自动将图形绘制到之前与canvas绑定的bitmap上,这里将尺寸进行改变，也就是实际绘制的Bitmap大小要比看到的图片大
        canvas.drawOval(RectF(0f, 0f, w * 3 / 4.toFloat(), h * 3 / 4.toFloat()), paint)
        return bitmap
    }

    //绘制矩形
    private fun makeSrcRect(w: Int, h: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.run {
            color = resources.getColor(R.color.Light_Blue)
            isAntiAlias = true
        }
        canvas.drawRect(w / 3.toFloat(), h / 3.toFloat(), w * 19 / 20.toFloat(), h * 19 / 20.toFloat(), paint)
        return bitmap
    }

    //将绘制的像素与canvas位置中对应的像素颜色进行混合的模式
    private val xModels = arrayOf<Xfermode>(
            PorterDuffXfermode(PorterDuff.Mode.CLEAR),
            PorterDuffXfermode(PorterDuff.Mode.SRC),
            PorterDuffXfermode(PorterDuff.Mode.DST),
            PorterDuffXfermode(PorterDuff.Mode.XOR),

            PorterDuffXfermode(PorterDuff.Mode.SRC_OVER),
            PorterDuffXfermode(PorterDuff.Mode.DST_OVER),
            PorterDuffXfermode(PorterDuff.Mode.SRC_IN),
            PorterDuffXfermode(PorterDuff.Mode.DST_IN),

            PorterDuffXfermode(PorterDuff.Mode.SRC_OUT),
            PorterDuffXfermode(PorterDuff.Mode.DST_OUT),
            PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP),
            PorterDuffXfermode(PorterDuff.Mode.DST_ATOP),

            PorterDuffXfermode(PorterDuff.Mode.DARKEN),
            PorterDuffXfermode(PorterDuff.Mode.LIGHTEN),
            PorterDuffXfermode(PorterDuff.Mode.MULTIPLY),
            PorterDuffXfermode(PorterDuff.Mode.SCREEN)
    )

    private val xModelLabels = arrayOf(
            "Clear", "Src", "Dst", "Xor",
            "SrcOver", "DstOver", "SrcIn", "DstIn",
            "SrcOut", "DstOut", "SrcATop", "DstATop",
            "Darken", "Lighten", "Multiply", "Screen")

    // 边框画笔
    private var mBorderPaint: Paint = Paint()
    // 字体画笔
    private var mTextPaint: Paint = Paint()

    private var isInit = false
    // 每个框的宽度
    private var itemWidth: Float = 0.toFloat()
    // 横向边界
    private val horizontalOffset = 10f
    // 纵向边界
    private var verticalOffset: Float = 0f

    // 边框的宽
    private val itemBorderWidth = 2

    // 字体大小
    private val mTextSize = 25

    private lateinit var ovalBitmap: Bitmap
    private lateinit var rectBitmap: Bitmap

    private var bitmapPaint: Paint = Paint()

    // 背景
    private var itemBackground: Shader? = null

    init {
        mBorderPaint.run {
            isAntiAlias = true
            color = Color.BLACK
            strokeWidth = itemBorderWidth.toFloat()
        }
        mTextPaint.run {
            isAntiAlias = true
            color = Color.BLACK
            textSize = mTextSize.toFloat()
            textAlign = Paint.Align.CENTER
        }

        bitmapPaint.isAntiAlias = true

        //创建边框中的背景图片
        val bm = Bitmap.createBitmap(intArrayOf(Color.WHITE, R.color.Grey200, R.color.Grey200, Color.WHITE),
                2, 2, Bitmap.Config.RGB_565)
        itemBackground = BitmapShader(bm,
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT)
        val m = Matrix()
        m.setScale(6f, 6f)
        itemBackground!!.setLocalMatrix(m)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //避免重复创建
        if (!isInit) {
            isInit = true
            val width = measuredWidth
            //计算每个矩形框宽大小
            itemWidth = (width - 4 * horizontalOffset) / 4
            verticalOffset = itemWidth * 0.1f

            val borderWidth = itemBorderWidth * 2
            //边框中圆与矩形图片大小
            ovalBitmap = makeDstOval((itemWidth - borderWidth).toInt(), (itemWidth - borderWidth).toInt())
            rectBitmap = makeSrcRect((itemWidth - borderWidth).toInt(), (itemWidth - borderWidth).toInt())
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (row in 0 until 4) {
            for (column in 0 until 4) {
                val translateX = horizontalOffset / 2 + (horizontalOffset + itemWidth) * column
                val translateY = (verticalOffset + mTextSize + itemWidth) * row

                val translateItem = verticalOffset + mTextSize
                mBorderPaint.shader = null
                mBorderPaint.style = Paint.Style.STROKE
                //画边框矩形
                canvas.drawRect(translateX,
                        translateY + translateItem,
                        translateX + itemWidth,
                        translateY + translateItem + itemWidth, mBorderPaint)
                //画边框内部图形
                mBorderPaint.shader = itemBackground
                mBorderPaint.style = Paint.Style.FILL
                canvas.drawRect(translateX,
                        translateY + translateItem,
                        translateX + itemWidth,
                        translateY + translateItem + itemWidth, mBorderPaint)

                // 新建一个图层，并放入到指定的栈中,是图层堆叠起来显示最终效果
                /**
                 * 我们在新建的layer上面绘制完成后，其实矩形区域的目标颜色也还是被重置为透明色(0,0,0,0)了，这样整个新建layer只有圆的3/4不是透明的，
                 * 其余像素全是透明的，然后我们调用canvas.restoreToCount()将该layer又绘制到了Canvas上面去了。在将一个新建的layer绘制到Canvas上去时，
                 * Android会用整个layer上面的像素颜色去更新Canvas对应位置上像素的颜色，并不是简单的替换，而是Canvas和新layer进行Alpha混合，
                 * 由于我们的layer中只有两种像素：完全透明的和完全不透明的，不存在部分透明的像素，并且完全透明的像素的颜色值的四个分量都为0，
                 * 所以本例就将Canvas和新layer进行Alpha混合的规则简化了，具体来说：

                如果新建layer上面某个像素的Alpha分量为255，即该像素完全不透明，那么Android会直接用该像素的ARGB值作为Canvas对应位置上像素的颜色值。
                如果新建layer上面某个像素的Alpha分量为0，即该像素完全透明，在本例中Alpha分量为0的像素，其RGB分量也都为0，那么Android会保留Canvas对应位置上像素的颜色值。
                这样当将新layer绘制到Canvas上时，完全不透明的3/4黄色圆中的像素会完全覆盖Canvas对应位置的像素，而由于在新layer上面绘制的矩形区域的像素ARGB都为(0,0,0,0)，
                所以最终Canvas上对应矩形区域还是保持之前的背景色，这样就不会出现白色的矩形了。

                大部分情况下，我们想要本例中实现的效果，而不是想要示例二中形成的白色矩形，
                所以大部分情况下在使用PorterDuffXfermode时都是结合canvas.saveLayer()、canvas.restoreToCount()的，将关键代码写在这两个方法之间。
                 */
                val layer = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
                canvas.translate(translateX, translateY)
                //绘制字体
                canvas.drawText(xModelLabels[row * 4 + column],
                        itemWidth / 2,
                        (mTextSize + verticalOffset) / 2 + 10,
                        mTextPaint)

                canvas.translate(0f, translateItem)
                //画圆
                bitmapPaint.xfermode = null
                canvas.drawBitmap(ovalBitmap, itemBorderWidth.toFloat(), itemBorderWidth.toFloat(), bitmapPaint)
                //画矩形
                bitmapPaint.xfermode = xModels[row * 4 + column]
                canvas.drawBitmap(rectBitmap, itemBorderWidth.toFloat(), itemBorderWidth.toFloat(), bitmapPaint)

                //弹出指定位置及以上所有状态，并根据指定位置进行状态恢复
                canvas.restoreToCount(layer)
            }
        }
    }
}