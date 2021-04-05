package com.example.android_thread.Async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_thread.AsyncExample;

public class Async extends AsyncTask<Void, Integer, String> {
    TextView textViewAsyncResult;
    Button buttonAsyncstart;
    Context context;
    ProgressDialog progressDialog;

    public Async(AsyncExample asyncExample, TextView textViewAsyncResult, Button buttonAsyncStart) {
        this.context = asyncExample;
        this.textViewAsyncResult = textViewAsyncResult;
        this.buttonAsyncstart = buttonAsyncStart;
    }
    /**  AsyncTask 執行前的準備工作，例如畫面上顯示進度表 */
    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Downloading in progress.....");
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }
    /**  實際要執行的程式碼就是寫在這裡 */
    @Override
    protected String doInBackground(Void... voids) {
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(1500);
                i++;
                // 呼叫 publishProgress() 以更新 UI 畫面,
                // 可藉由此方式更新畫面上的進度表
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 將 Download Complete 傳給 onPostExecute()
        return "Download Complete";
    }
    /** 用來顯示目前的進度 */
    @Override
    protected void onProgressUpdate(Integer... values) {
        // 這裡接收傳入的 progress 值, 並更新進度表畫面
        // 參數是 Integer 型態的陣列
        // 但是因為在 doInBackground() 只傳一個參數
        // 所以以 progress[0] 取得傳入參數
        int progress = values[0];
        progressDialog.setProgress(progress);
        textViewAsyncResult.setText("Downloading in progress....");
    }
    /** 執行完的結果 - Result 會傳入這裡 */
    @Override
    protected void onPostExecute(String result) {
        textViewAsyncResult.setText(result);
        buttonAsyncstart.setEnabled(true);
        progressDialog.hide();
    }
}

