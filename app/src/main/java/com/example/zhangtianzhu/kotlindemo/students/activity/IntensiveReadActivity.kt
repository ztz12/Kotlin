package com.example.zhangtianzhu.kotlindemo.students.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.students.base.BaseActivity
import com.example.zhangtianzhu.kotlindemo.utils.AlphaUtils
import kotlinx.android.synthetic.main.activity_intensive_read.*

class IntensiveReadActivity : BaseActivity() {

    private lateinit var qsPopupWindow: PopupWindow
    private lateinit var wordsPopupWindow: PopupWindow
    private lateinit var sentencePopupWindow: PopupWindow

    override fun getLayoutId(): Int {
        return R.layout.activity_intensive_read
    }

    override fun initData() {

    }

    override fun initView() {
        showQuesPopup()
        showWordsPopup()
        showSentencesPopup()
    }

    private fun showQuesPopup(){
        val contentView:View = LayoutInflater.from(this).inflate(R.layout.qs_popupwindow,null)
        qsPopupWindow = PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true)
        tv_questionR.setOnClickListener { v -> showQsPopupWindow(v) }
        tv_questionL.setOnClickListener { v -> showQsPopupWindow(v) }
        qsPopupWindow.setOnDismissListener { AlphaUtils.backgroundAlpha(this,1.0f) }
    }

    private fun showWordsPopup(){
        val contentView:View = LayoutInflater.from(this).inflate(R.layout.import_words_popup,null)
        wordsPopupWindow = PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true)
        btn_import_word.setOnClickListener { v -> showWPopupWindow(v) }
        wordsPopupWindow.setOnDismissListener { AlphaUtils.backgroundAlpha(this,1.0f) }
    }

    private fun showSentencesPopup(){
        val contentView:View = LayoutInflater.from(this).inflate(R.layout.import_sentence_popup,null)
        sentencePopupWindow = PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true)
        btn_import_sentence.setOnClickListener { v ->  showSPopupWindow(v)}
        sentencePopupWindow.setOnDismissListener { AlphaUtils.backgroundAlpha(this,1.0f) }
    }

    private fun showQsPopupWindow(view: View){
        qsPopupWindow.isOutsideTouchable = true
        AlphaUtils.backgroundAlpha(this,0.5f)
        qsPopupWindow.showAsDropDown(view,AlphaUtils.dpToPx(-10f,this).toInt(),0)
    }

    private fun showWPopupWindow(view: View){
        wordsPopupWindow.isOutsideTouchable = true
        AlphaUtils.backgroundAlpha(this,0.5f)
        wordsPopupWindow.showAsDropDown(view,AlphaUtils.dpToPx(-10f,this).toInt(),0)
    }
    private fun showSPopupWindow(view: View){
        sentencePopupWindow.isOutsideTouchable = true
        AlphaUtils.backgroundAlpha(this,0.5f)
        sentencePopupWindow.showAsDropDown(view,AlphaUtils.dpToPx(-10f,this).toInt(),0)
    }
}
