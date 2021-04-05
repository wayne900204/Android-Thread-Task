package com.example.android_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonAsync, buttonHandler, buttonTimer, buttonRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAsync = (Button) findViewById(R.id.buttonAsync);
        buttonHandler = (Button) findViewById(R.id.buttonHandler);
        buttonTimer = (Button) findViewById(R.id.buttonTimer);
        buttonRun = (Button) findViewById(R.id.buttonRun);

        buttonAsync.setOnClickListener(this);
        buttonHandler.setOnClickListener(this);
        buttonTimer.setOnClickListener(this);
        buttonRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAsync: {
                Intent intent = new Intent(MainActivity.this, AsyncExample.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonHandler: {
                Intent intent = new Intent(MainActivity.this, HandlerExample.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonTimer: {
                Intent intent = new Intent(MainActivity.this, TimerExample.class);
                startActivity(intent);
                break;
            }
            case R.id.buttonRun: {
                Intent intent = new Intent(MainActivity.this, RunExample.class);
                startActivity(intent);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}