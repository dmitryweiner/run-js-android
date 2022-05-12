package com.example.run_js_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {
        EditText input = findViewById(R.id.editTextInput);
        EditText output = findViewById(R.id.editTextOutput);

        WebView webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        try {
            webView.evaluateJavascript(input.getText().toString(), new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {
                    output.setText(s);
                }
            });
        } catch (Exception e) {
            output.setText("Error: " + e.toString());
            Log.e(getApplicationContext().getPackageName(), e.toString());
        }
    }
}