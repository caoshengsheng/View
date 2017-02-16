package com.ipc.sean.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by css on 17/2/16.
 */

public class TestButton extends View {
    private static final String TAG = "TestButton";
    private int mScaledTouchSlop;
    // 分别记录上次滑动的坐标
    private int mLastX = 100;//初始化view的x坐标点
    private int mLastY = 100;//初始化view的y坐标点



    public TestButton(Context context) {
        this(context, null);
    }

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mScaledTouchSlop = ViewConfiguration.get(getContext())
                .getScaledTouchSlop();
        Log.d(TAG, "sts:" + mScaledTouchSlop);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //getRawX 获取相对于手机屏幕上左上角的x坐标，手指当前的坐标
        //getRawX 获取相对于手机屏幕上左上角的y坐标，手指当前的坐标
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        Log.d(TAG, "getRawX: "+event.getRawX());
        Log.d(TAG, "getX: "+this.getX());
        Log.d(TAG, "getTranslationX: "+this.getTranslationX());

        Log.d(TAG, "getRawY: "+event.getRawY());
        Log.d(TAG, "getY: "+this.getY());
        Log.d(TAG, "getTranslationY: "+this.getTranslationY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {//手指刚接触屏幕
                break;
            }
            case MotionEvent.ACTION_MOVE: {//手指在屏幕上移动
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                //translationX相对于父容器的x偏移量
                //translationX相对于父容器的y偏移量
                int translationX = (int) this.getTranslationX() + deltaX;
                int translationY = (int) this.getTranslationY() + deltaY;
                this.setTranslationX( translationX);
                this.setTranslationY( translationY);
                break;
            }
            case MotionEvent.ACTION_UP: {//手指从屏幕上松开的一瞬间
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;

        return true;
    }
}
