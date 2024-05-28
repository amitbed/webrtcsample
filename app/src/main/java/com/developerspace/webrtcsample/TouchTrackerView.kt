package com.developerspace.webrtcsample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class TouchTrackerView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val localTouchPoints = mutableListOf<TouchPoint>()
    private var remoteTouchPoints = mutableListOf<TouchPoint>()

    private var touchDataListener: TouchDataListener? = null

    private val localPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    private val remotePaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.actionMasked

        when (action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                val pointerIndex = event.actionIndex
                val fingerId = event.getPointerId(pointerIndex)
                val x = event.getX(pointerIndex)
                val y = event.getY(pointerIndex)
                localTouchPoints.add(TouchPoint(fingerId, x, y))
            }

            MotionEvent.ACTION_MOVE -> {
                var i = 0
                while (i < event.pointerCount) {
                    val fingerId = event.getPointerId(i)
                    val x = event.getX(i)
                    val y = event.getY(i)
                    val index = findTouchPointIndex(fingerId)
                    if (index != -1) {
                        localTouchPoints[index].x = x
                        localTouchPoints[index].y = y
                    }
                    i++
                }
            }

            MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_UP -> {
                val pointerIndex = event.actionIndex
                val fingerId = event.getPointerId(pointerIndex)
                removeTouchPoint(fingerId)
            }
        }
        touchDataListener?.onSendTouchData(localTouchPoints)
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (touchPoint in localTouchPoints) {
            canvas.drawCircle(touchPoint.x, touchPoint.y, 50f, localPaint)
        }
        for (touchPoint in remoteTouchPoints) {
            canvas.drawCircle(touchPoint.x, touchPoint.y, 50f, remotePaint)
        }
    }

    fun displayRemoteTouches(touches: List<TouchPoint>) {
        remoteTouchPoints = touches.toMutableList()
    }

    private fun findTouchPointIndex(fingerId: Int): Int {
        for (i in 0 until localTouchPoints.size) {
            if (localTouchPoints[i].fingerId == fingerId) {
                return i
            }
        }
        return -1
    }

    private fun removeTouchPoint(fingerId: Int) {
        val index = findTouchPointIndex(fingerId)
        if (index != -1) {
            localTouchPoints.removeAt(index)
        }
    }

    fun setSendDataListener(listener: TouchDataListener) {
        this.touchDataListener = listener
    }

    interface TouchDataListener {
        fun onSendTouchData(touchPoints: List<TouchPoint>)
    }
}