package com.example.run_js_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
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

        Context context = Context.enter(); //
        context.setOptimizationLevel(-1); // this is required[2]
        Scriptable scope = context.initStandardObjects();
        Object result = context.evaluateString(scope, input.getText().toString(), "<cmd>", 1, null);
        output.setText(result.toString());
    }
}