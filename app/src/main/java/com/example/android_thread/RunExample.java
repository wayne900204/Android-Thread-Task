package com.example.android_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RunExample extends AppCompatActivity implements View.OnClickListener{

    TextView textViewRun, textViewRunResult;
    Button buttonRunStart;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_example);

        textViewRun = (TextView) findViewById(R.id.textViewRun);
        textViewRunResult = (TextView) findViewById(R.id.textViewRunResult);
        buttonRunStart = (Button) findViewById(R.id.buttonRunStart);
        buttonRunStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RunTask();
    }
    private void RunTask() {
        progressDialog = new ProgressDialog(RunExample.this);
        progressDialog.setMax(10);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i <= 10) {
                    int Progress = i;
                    try {
                        Thread.sleep(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setProgress(Progress);
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewRunResult.setText("Download Complete");
                        progressDialog.hide();
                    }
                });
            }
        }).start();
    }
}