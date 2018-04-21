package com.example.wehelie.homeworkv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button goback = (Button) findViewById(R.id.refresh);
        // get the text from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra(Constants.KEY_NAME);
        String email = intent.getStringExtra(Constants.KEY_EMAIL);
        String age = intent.getStringExtra(Constants.KEY_AGE);
        String date = intent.getStringExtra(Constants.KEY_DOB);

        // use the text in a TextView
        TextView textView = (TextView) findViewById(R.id.view);

        textView.setText("Thanks for Signing Up "  + name + "!");

        // upon click, go back to the empty form
        goback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // call this to finish the current activity
            }
        });

    }

}
