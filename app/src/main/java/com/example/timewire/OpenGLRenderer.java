package com.example.timewire;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.google.android.material.shape.TriangleEdgeTreatment;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private volatile int width;
    private volatile int height;
    private volatile float touchX;
    private volatile float touchY;


    public void setTouchX(float touchX) {
        this.touchX = touchX;
    }

    public void setTouchY(float touchY) {
        this.touchY = touchY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.1f,0.2f,0.3f,1f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor(touchX/width,touchY/height,0.1f,1f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }

    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}
