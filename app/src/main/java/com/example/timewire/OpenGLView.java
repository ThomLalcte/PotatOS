package com.example.timewire;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class OpenGLView extends GLSurfaceView {

    private final OpenGLRenderer renderer = new OpenGLRenderer();

    private float previousX;
    private float previousY;


    public OpenGLView(Context context) {
        super(context);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        init();
    }

    public OpenGLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(renderer);
        /*renderer.setHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        renderer.setWidth(Resources.getSystem().getDisplayMetrics().widthPixels);*/
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                /*float dx = x-previousX;
                float dy = y-previousY;*/
                renderer.setTouchX(x);
                renderer.setTouchY(y);
                requestRender();
            break;
        }
        previousX = x;
        previousY = y;
        return true;
    }
}
