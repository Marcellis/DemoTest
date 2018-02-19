package com.example.marmm.demolevel3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by marmm on 2/18/18.
 */

public class DataSource {


    private Context mContext;
    private SQLiteDatabase mDatabase;
    private DBHelper mDBHelper;
    private String[] REMINDERS_ALL_COLUMNS = {  RemindersContract.ReminderEntry._ID,
            RemindersContract.ReminderEntry.COLUMN_NAME_REMINDER};



    public DataSource(Context context) {
        mContext = context;
        mDBHelper = new DBHelper(mContext);
    }

    // Opens the database to use it
    public void open()  {
        mDatabase = mDBHelper.getWritableDatabase();
    }
    // Closes the database when you no longer need it
    public void close() {
        mDBHelper.close();
    }


    public void createReminder(String reminderText) {
        ContentValues values = new ContentValues();
        values.put(RemindersContract.ReminderEntry.COLUMN_NAME_REMINDER, reminderText);
        mDatabase.insert(RemindersContract.ReminderEntry.TABLE_NAME, null, values);
    }

    public Cursor getAllReminders() {
        return mDatabase.query(RemindersContract.ReminderEntry.TABLE_NAME,
                REMINDERS_ALL_COLUMNS, null, null, null, null, null);
    }



}
