package com.geekdata. gesturedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    var startY:Float = 1f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.actionMasked){
            MotionEvent.ACTION_POINTER_DOWN-> startY = event.getY(0)

            MotionEvent.ACTION_POINTER_UP -> {
                val endY =event.getY(0)
                if (event?.pointerCount==3&& 5>startY-endY){
                    startActivity<TestActivity>()
                }
            }
        }
        return super.onTouchEvent(event)
    }
}
