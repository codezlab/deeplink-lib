package com.codezlab.deeplink_lib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.codezlab.mydeeplink.HelperFunction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelperFunction helperFunction = new HelperFunction();

        String message = helperFunction.getMessage();

        TextView view = findViewById(R.id.messageTv);
        view.setText(message);
    }
}