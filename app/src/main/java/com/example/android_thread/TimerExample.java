package com.example.android_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample extends AppCompatActivity implements View.OnClickListener {

    public int i = 0;
    TextView textViewTimer, textViewTimerResult;
    Button buttonTimerStart, buttonTimerStop;
    Timer timer;
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_example);

        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        textViewTimerResult = (TextView) findViewById(R.id.textViewTimerResult);
        buttonTimerStart = (Button) findViewById(R.id.buttonTimerStart);
        buttonTimerStop = (Button) findViewById(R.id.buttonTimerStop);
        buttonTimerStart.setOnClickListener(this);
        buttonTimerStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTimerStart: {
                stopTimer();
                timer = new Timer();
                timerTask = new TimerTask() {
                    public void run() {
                        try {
                            i = i + 5;
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            public void run() {
                                textViewTimerResult.setText("Seconds =" + i);
                            }
                        });
                    }
                };
                // 從線在起過 delay 毫秒以後，每隔 period
                // 毫秒執行一次。
                timer.schedule(timerTask, 5000, 5000);
                break;
            }
            case R.id.buttonTimerStop: {
                stopTimer();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
    private  void stopTimer(){
        if (timer != null) {
            timer.cancel();
            timer = null;
            i = 0;
        }
    }
}