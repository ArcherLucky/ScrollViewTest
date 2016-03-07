package com.liuzhe.scrollviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ScrollView scrollView;

    float lastY;
    float scrollSum;

    boolean isEnabled = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(android.R.id.button1);
//        button.getParent().requestDisallowInterceptTouchEvent(true);


        scrollView = (ScrollView) findViewById(android.R.id.home);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (isEnabled) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            Log.e("tag", "onTouch().DOWN--do nothing");
                            break;
                        case MotionEvent.ACTION_MOVE:
                            Log.e("tag", "onTouch().MOVE");
                            break;
                        case MotionEvent.ACTION_UP:
                            Log.e("tag", "onTouch().UP");
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float clickY = lastY + scrollSum;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = ev.getRawY();
                isEnabled = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (button.getTop() < clickY && button.getBottom() > clickY) {
                    button.setEnabled(false);
                    Log.e("button", "button不能用啦");
                    isEnabled = false;
                } else {
                    isEnabled = true;
                }
                float scrollY = ev.getRawY() - lastY;
                lastY = ev.getRawY();
                scrollSum += -scrollY;
                break;
            case MotionEvent.ACTION_UP:
                isEnabled = true;
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


}
