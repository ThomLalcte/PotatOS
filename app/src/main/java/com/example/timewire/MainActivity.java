package com.example.timewire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private OpenGLView openGLView;
    protected static int[] touchPos = {0,0};
    protected static int[] screenSize = {Resources.getSystem().getDisplayMetrics().widthPixels,Resources.getSystem().getDisplayMetrics().heightPixels};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openGLView = findViewById(R.id.openGLView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        openGLView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        openGLView.onPause();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchPos[0] = (int)event.getX();
        touchPos[1] = (int)event.getY();

        /*switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }*/


        return super.onTouchEvent(event);
    }
}