package com.example.timewire;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private final int width = MainActivity.screenSize[0];
    private final int height = MainActivity.screenSize[1];

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.1f,0.2f,0.3f,1f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor((float)MainActivity.touchPos[0]/width,(float) MainActivity.touchPos[1]/height,0.1f,1f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
