package com.example.marmm.demotest;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    private EditText mReminderView;
    private long mID;
    private DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mReminderView = (EditText) findViewById(R.id.editText_update);

        //Obtain parameters provided by MainActivity
        mID = getIntent().getLongExtra(MainActivity.REMINDER_POSITION, -1);

        //Initiate and open DataSource
        mDataSource = new DataSource(this);
        mDataSource.open();

        //Get current reminder name
        Cursor mCursor = mDataSource.getOneReminder(mID);
        if (mCursor != null)
            mCursor.moveToFirst();
        mReminderView.setText(mCursor.getString(mCursor.getColumnIndex(RemindersContract.ReminderEntry.COLUMN_NAME_REMINDER)));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedReminderText = mReminderView.getText().toString();
                if (!TextUtils.isEmpty(updatedReminderText)) {
                    //Prepare the return parameter and return

                    mDataSource.updateReminder(mID,updatedReminderText);
                    mDataSource.close();

                    setResult(Activity.RESULT_OK);

                    finish();
                } else {
                    Snackbar.make(view, "Enter some data", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });
    }

}
