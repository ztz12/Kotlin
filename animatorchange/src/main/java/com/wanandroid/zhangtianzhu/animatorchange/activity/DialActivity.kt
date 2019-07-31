package com.wanandroid.zhangtianzhu.animatorchange.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.wanandroid.zhangtianzhu.animatorchange.R
import kotlinx.android.synthetic.main.activity_dial.*

class DialActivity : AppCompatActivity() {
    // 最多五段
    private val LINE_MAX = 5
    private var lineCount = 3
    private var curCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dial)

        setLevelTv(lineCount)
        setCurLevelNumTv(curCount)

        dialView.setValue(curCount)
        dialView.setLineCount(lineCount)

        sbLevel.max = LINE_MAX
        sbLevelNum.max = lineCount

        sbLevel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                lineCount = progress + 2
                setLevelTv(lineCount)
                dialView.reset()
                dialView.setLineCount(lineCount)
                sbLevelNum.max = lineCount - 1

                val oldMax = sbLevelNum.max
                if (oldMax > lineCount) {
                    dialView.setValue(lineCount)

                    sbLevelNum.progress = lineCount - 1
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        sbLevelNum.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                curCount = progress + 1
                dialView.setValue(curCount)
                setCurLevelNumTv(curCount)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    fun onRun(view: View) {
        dialView.start()
    }

    fun onReset(view: View) {
        dialView.reset()
    }

    private fun setLevelTv(num: Int) {
        tvLevel.text = String.format(getString(R.string.level_num), num)
    }

    private fun setCurLevelNumTv(num: Int) {
        tvLevelNum.text = String.format(getString(R.string.cur_level_num), num)
    }
}
