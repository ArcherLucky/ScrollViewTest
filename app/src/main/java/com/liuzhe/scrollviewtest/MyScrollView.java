package com.liuzhe.scrollviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by 84113 on 2016/3/7.
 */
public class MyScrollView extends ScrollView {

    public MyScrollView(Context context) {
        super(context);
        init();
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        this.setOnTouchListener(onTouchListener);
    }

    OnTouchListener onTouchListener=new OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.e("tag", "ScrollView onTouch().DOWN");
                    onScrollListener.actionDown();
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.e("tag", "ScrollView onTouch().MOVE");
                    onScrollListener.actionMove();
                    break;
                case MotionEvent.ACTION_UP:
                    Log.e("tag", "ScrollView onTouch().UP");
                    onScrollListener.actionUp();
                    break;

                default:
                    break;
            }
            return false;
        }

    };

    /**
     * 定义接口
     * @author admin
     *
     */
    public interface OnScrollListener{
        void actionDown();
        void actionUp();
        void actionMove();
    }
    private OnScrollListener onScrollListener;
    public void setOnScrollListener(OnScrollListener onScrollListener){
        this.onScrollListener=onScrollListener;
    }
}
