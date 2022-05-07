package com.example.run_js_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.eclipsesource.v8.V8;
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

        V8 runtime = V8.createV8Runtime();
        try {
            Object result = runtime.executeScript(input.getText().toString());
            output.setText(result.toString());
        } catch (Exception e) {
            output.setText("Error: " + e.toString());
            Log.e(getApplicationContext().getPackageName(), e.toString());
        } finally {
            runtime.release();
        }
    }
}