package com.example.android_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_thread.Async.Async;

public class AsyncExample extends AppCompatActivity implements View.OnClickListener{
    TextView textViewAsync,textViewAsyncResult;
    Button buttonAsyncStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_example);
        textViewAsync = (TextView) findViewById(R.id.textViewAsync);
        textViewAsyncResult = (TextView) findViewById(R.id.textViewAsyncResult);
        buttonAsyncStart = (Button) findViewById(R.id.buttonAsyncStart);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAsyncStart: {
                Async async=new Async(AsyncExample.this,textViewAsyncResult,buttonAsyncStart);
                async.execute();
                buttonAsyncStart.setEnabled(false);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}