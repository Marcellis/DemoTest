package com.example.marmm.demolevel3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText mReminderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Init local variables
        mReminderView = (EditText) findViewById(R.id.editText_update);

//Obtain the parameters provided by MainActivity
        final int  position = getIntent().getIntExtra (MainActivity.REMINDER_POSITION,-1);
//If no "position in list" can be found, the default value is -1. This could be used to recognize an issue.

       // final Reminder reminderUpdate =   MainActivity.mReminders.get(position);
     //   mReminderView.setText (reminderUpdate.getmReminderText());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Return entered data to MainActivity (if not empty, else throw a snackbar message
                String updatedReminderText = mReminderView.getText().toString();
     //           reminderUpdate.setmReminderText(updatedReminderText);

      //          MainActivity.mReminders.set(position,reminderUpdate);
                //(reminderUpdate.setmReminderText(updatedReminderText)));
                if (!TextUtils.isEmpty(updatedReminderText)){

       //             Toast.makeText(UpdateActivity.this, reminderUpdate+" updated to"+ updatedReminderText, Toast.LENGTH_SHORT).show();
                     finish();
                } else {
                    Snackbar.make(view, "Enter some data", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }




}
