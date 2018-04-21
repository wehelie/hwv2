package com.example.wehelie.homeworkv2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private TextView DisplayDate;

    private DatePickerDialog.OnDateSetListener DateWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // displays birthdate
        DisplayDate = (TextView) findViewById(R.id.seedate);
        Button submit = findViewById(R.id.go);

        // Upon clicking the date view text box
        DisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                // setup datepicker feature
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
                        DateWatcher,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        // show datepicker dialog window
        DateWatcher = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // jan is 0 so we need to 1
                month = month + 1;
                String date = month + " / " + dayOfMonth + "/" + year;

                DisplayDate.setText(date);

            }
        };

        // submit the user information
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the text to pass
                EditText editTextName = (EditText) findViewById(R.id.editText);
                String name = editTextName.getText().toString();

                EditText editTextEmail = (EditText) findViewById(R.id.email);
                String email = editTextEmail.getText().toString();

                EditText editTextUsername = (EditText) findViewById(R.id.username);
                String username = editTextUsername.getText().toString();

                TextView date = (TextView) findViewById(R.id.seedate);
                String dateToPass = date.getText().toString();

                TextView editTextAge = (TextView) findViewById(R.id.age);
                String age = editTextAge.getText().toString();


                // start the SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Constants.KEY_NAME, name);
                intent.putExtra(Constants.KEY_EMAIL, email);
                intent.putExtra(Constants.KEY_USERNAME, username);
                intent.putExtra(Constants.KEY_AGE, age);
                intent.putExtra(Constants.KEY_DOB, dateToPass);


                // simple validation
                if(name == null || name.equals("")){
                    editTextName.setError(" You must be 18 or up to sign up for this program");
                }
                else if(email == null || email.equals("")){
                    editTextEmail.setError(" Email is required");

                }else if (username == null || username.equals("")) {
                    editTextUsername.setError("Username is required");
                } else if(age == null || age.equals("")){
                    editTextAge.setError(" Age is required");
                } else if( age.equals("")){
                    editTextAge.setError(" You must enter your age!");
                }else if(Integer.parseInt(age) < 18){
                    editTextAge.setError(" You must be 18 or up to sign up for this program");
                } else{
                    // if all is well, start activity
                    startActivity(intent);
                }
            }
        });
    }

}
