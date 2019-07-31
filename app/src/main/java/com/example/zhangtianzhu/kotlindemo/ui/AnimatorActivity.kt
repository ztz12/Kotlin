package com.example.zhangtianzhu.kotlindemo.ui

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.Window
import com.example.zhangtianzhu.kotlindemo.R
import kotlinx.android.synthetic.main.activity_animator.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult

class AnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_animator)
        btn_animator.setOnClickListener {
//            startActivity<AnimatorActivityTwo>()
            startActivityForResult<AnimatorActivityTwo>(1)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
//        setIntent(intent)
        val text = intent?.getStringExtra("info")
        tv_date.text  =text
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                if(data!=null){
                    val text = data.getStringExtra("info")
                    tv_date.text = text
                }
            }
        }
    }

    private fun setAnimator(){
        //告诉window切换动画
        //explore 爆炸效果
        val explore:Transition = TransitionInflater.from(this).inflateTransition(R.transition.fade)
        window.enterTransition = explore
        window.exitTransition = explore
        //再次进入
        window.reenterTransition = explore
        val intent = Intent(this,AnimatorActivityTwo::class.java)
        startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this,firstView,"shareView").toBundle())
//        startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}
