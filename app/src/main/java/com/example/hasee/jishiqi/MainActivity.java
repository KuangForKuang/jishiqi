package com.example.hasee.jishiqi;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

    private TextView tv_timer;
    private ImageView img_start;
    private boolean isStopCount = false;

    private boolean isPause = true;

    private Handler mHandler = new Handler();

    private long timer = 0;
    private String timeStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        countTimer();
    }

    private void findViews() {
        tv_timer = (TextView) findViewById(R.id.tv_timer);
        img_start = (ImageView) findViewById(R.id.img_start);
        img_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_start:
                if(!isPause){
                    isPause = true;
                    isStopCount = false;
                    img_start.setImageResource(R.drawable.btn_pause);
                } else{
                    isPause = false;
                    isStopCount = true;
                    img_start.setImageResource(R.drawable.btn_start);
                }
                break;

            default:
                break;
        }
    }

    private Runnable TimerRunnable = new Runnable() {

        @Override
        public void run() {
            if(!isStopCount){
                timer += 1000;
                timeStr = TimeUtil.getFormatTime(timer);
                tv_timer.setText(timeStr);
            }
            countTimer();
        }
    };

    private void countTimer(){
        mHandler.postDelayed(TimerRunnable, 1000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(TimerRunnable);
    }




}


